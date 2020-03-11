# EasyAdapter
还在为RecyclerView适配而烦恼吗？
赶快使用EasyAdapter吧！
https://blog.csdn.net/best335/article/details/104735231
# 使用步骤
### 首先新建一个Android Studio项目
修改app的build.gradle文件

```java
//support SDK
android{
	...
	compileOptions {
        sourceCompatibility 1.8
        targetCompatibility 1.8
    }
	...
}
dependencies {
	...
	api "com.github.isong0623:EasyAdapter:1.0-support"
	...
}
//androidx SDK
dependencies {
	...
	api "com.github.isong0623:EasyAdapter:1.0-androidx"
	...
}
```
### 新建recy_item.xml布局文件
![](https://img-blog.csdnimg.cn/20200308164720933.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2Jlc3QzMzU=,size_16,color_FFFFFF,t_70)
### 加载这个控件布局到RecyclerView 
```java
 	RecyclerView recy = findViewById(R.id.recy);
        List<String> lstDatas = new ArrayList<>(Arrays.asList(new String[]{"1","2","3","4","5","6","7","8","9"}));
        EasyAdapter.IEasyAdapter iEasyAdapter = new EasyAdapter.IEasyAdapter<String>() {//这个接口对象会在RecyclerView初始化item时调用convert方法
            @Override
            public void convert(EasyViewHolder holder, String data, int position) {//在这里处理每个子布局
                //holder持有了由recy_item.xml构造的根View对象，所以通过holder可以处理这个布局里所有的子控件
                holder.getViewAsTextView(R.id.textView).setText(data);
                holder.getViewAsImageView(R.id.imageView).setTag(data);
                holder.getViewAsEditText(R.id.editText).setText(data);
                holder.getView(R.id.editText).setVisibility(View.VISIBLE);
                TextView tv = holder.getView(R.id.textView);
//                holder.setImageBitmap(R.id.imageView,null);
                holder.setVisibility(R.id.textView,View.VISIBLE);
                holder.getView(R.id.imageView).setBackgroundColor(Color.parseColor("#00000000"));
                //如上操作我们可以自由地取到根View里的所有控件对其操作
            }
        };
        recy.setLayoutManager(new LinearLayoutManager(this));
		//实现方式1，使用RecyclerView的缓存机制，对于控件尺寸变动无法保证正常显示。
        recy.setAdapter(new EasyAdapter(this, R.layout.recy_item, lstDatas,iEasyAdapter));
		//实现方式2，禁止RecyclerView缓存，保证每个布局显示正常。
        recy.setAdapter(new EasyAdapter(this, R.layout.recy_item,lstDatas,iEasyAdapter,false));
```
## 加载效果
![](https://img-blog.csdnimg.cn/20200308165808342.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2Jlc3QzMzU=,size_16,color_FFFFFF,t_70)
# EasyViewHolder 的更多用法
![](https://img-blog.csdnimg.cn/20200308165144481.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2Jlc3QzMzU=,size_16,color_FFFFFF,t_70)
