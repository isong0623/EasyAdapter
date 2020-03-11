package priv.songxusheng.easyadapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @作者 宋旭升
 */
public final class EasyAdapter<T> extends RecyclerView.Adapter<EasyViewHolder>  {
    public interface IEasyAdapter<T>{
        void convert(EasyViewHolder holder, T data, int position);
    }
    private Context context;
    private int layoutResID;
    private boolean bIsUseCache = true;
    private IEasyAdapter iEasyAdapter;
    private List<T> lstDatas;
    private Handler handler = new Handler();

    private void convert(EasyViewHolder holder, T data, int position){
        iEasyAdapter.convert(holder,data,position);
    }

    private EasyAdapter(Context context, @LayoutRes int layoutResID, List<T> lstDatas){
        this.context = context;
        this.layoutResID = layoutResID;
        this.lstDatas = lstDatas;
    }

    public EasyAdapter(Context context, @LayoutRes int layoutResID, List<T> lstDatas,IEasyAdapter<T> iEasyAdapter){
        this(context,layoutResID,lstDatas);
        this.iEasyAdapter = iEasyAdapter;
    }

    public EasyAdapter(Context context, @LayoutRes int layoutResID, List<T> lstDatas,IEasyAdapter<T> iEasyAdapter,boolean isUseCache){
        this(context,layoutResID,lstDatas,iEasyAdapter);
        setCacheEnabled(isUseCache);
    }

    public EasyAdapter setCacheEnabled(boolean isUserCache){
        setHasStableIds(!(bIsUseCache=isUserCache));
        return this;
    }

    @Override
    public EasyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(LayoutInflater.from(context).inflate(layoutResID,parent,false));
    }

    @Override
    public void onBindViewHolder(EasyViewHolder holder, int position) {
        handler.postDelayed(()->{
            try { convert(holder, lstDatas.get(position),position); } catch (Exception e) {e.printStackTrace();
                Log.e("EasyAdapter",e.getMessage()); }
        },10);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if(!bIsUseCache&&recyclerView!=null){
            recyclerView.getRecycledViewPool().setMaxRecycledViews(0,0);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lstDatas==null?0:lstDatas.size();
    }
}