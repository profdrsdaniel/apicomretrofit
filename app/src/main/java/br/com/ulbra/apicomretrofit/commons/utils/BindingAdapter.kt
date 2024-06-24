package br.com.ulbra.apicomretrofit.commons.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("carregaImg")
    @JvmStatic
    fun ImageView.carregaImg(url: String) {
        Glide
            .with(context)
            .load(url)
            .into(this)
    }
}