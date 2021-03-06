package com.wd.tech.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.youth.banner.loader.ImageLoader
import com.facebook.drawee.view.SimpleDraweeView



/**
 * FileName: GlideImageLoader
 * Author: 杨明森
 * Date: 2019/4/8 19:54
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        /**
        注意：
        1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
        2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
        传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
        切记不要胡乱强转！
         */

        //Glide 加载图片简单用法
       // Glide.with(context).load(path).into(imageView);

        //Picasso 加载图片简单用法
        //Picasso.with(context).load(path).into(imageView);

        //用fresco加载图片简单用法，记得要写下面的createImageView方法
        var uri = Uri.parse(path as String?)
        imageView!!.setImageURI(uri);
    }

    //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
    override fun createImageView(context: Context): ImageView {
        //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
        return SimpleDraweeView(context)
    }
}