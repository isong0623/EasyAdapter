package priv.songxusheng.easyadapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EasyViewHolder extends RecyclerView.ViewHolder{
    private View vRoot;
    public EasyViewHolder(View itemView) {
        super(itemView);
        vRoot = itemView;
//        setIsRecyclable(false);
    }

    public final <T extends View> T getView(@IdRes int id){
        return vRoot.findViewById(id);
    }

    public <T> T getViewAs(@IdRes int id,T defaultView){
        try {
            return (T)vRoot.findViewById(id);
        } catch (Exception e) {
            return defaultView;
        }
    }

    public ImageView getViewAsImageView(@IdRes int id){
        try{ return (ImageView)getView(id); }catch (Exception e){e.printStackTrace();
            Log.e("EasyViewHolder",e.getMessage());}
        return null;
    }

    public EditText getViewAsEditText(@IdRes int id){
        try{ return (EditText)getView(id); }catch (Exception e){e.printStackTrace();
            Log.e("EasyViewHolder",e.getMessage());}
        return null;
    }

    public TextView getViewAsTextView(@IdRes int id){
        try{ return (TextView)getView(id); }catch (Exception e){e.printStackTrace();
            Log.e("EasyViewHolder",e.getMessage());}
        return null;
    }

    public void setOnClickListener(@IdRes int id , View.OnClickListener listener){
        try { getView(id).setOnClickListener(listener); } catch (Exception e) { }
    }

    public void setText(@IdRes int id , String text){
        try { getViewAsTextView(id).setText(text);} catch (Exception e) {}
    }

    public void setImageDrawable(@IdRes int id, Drawable drawable){
        try { getViewAsImageView(id).setImageDrawable(drawable);} catch (Exception e) {}
    }

    public void setTextColor(@IdRes int id , int color){
        try { getViewAsTextView(id).setTextColor(color);} catch (Exception e) {}
    }

    public void setBackgroundRes(@IdRes int id , @DrawableRes int res){
        try { getView(id).setBackgroundResource(res); } catch (Exception e) { }
    }
    public void setVisible(@IdRes int id, boolean visible){
        try { getView(id).setVisibility(visible? View.VISIBLE: View.GONE); } catch (Exception e) { }
    }

    public void setVisibility(@IdRes int id, int visibility){
        try { getView(id).setVisibility(visibility); } catch (Exception e) { }
    }

    public void setImageResource(@IdRes int id , @DrawableRes int res){
        try { getViewAsImageView(id).setImageResource(res);} catch (Exception e) {}
    }

    public void setBackgroundColor(@IdRes int id, int color){
        try { getView(id).setBackgroundColor(color); } catch (Exception e) { }
    }

    public void setTag(@IdRes int id, Object tag){
        try { getView(id).setTag(tag); } catch (Exception e) { }
    }

    public void setImageBitmap(@IdRes int id, Bitmap bitmap){
        try { getViewAsImageView(id).setImageBitmap(bitmap);} catch (Exception e) {}
    }
}