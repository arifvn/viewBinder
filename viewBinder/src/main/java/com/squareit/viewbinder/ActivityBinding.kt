package com.squareit.viewbinder

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> AppCompatActivity.viewBinder() =
    ActivityBinding(T::class.java)

class ActivityBinding<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<AppCompatActivity, T> {

    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {

        binding?.let { return it }

        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)

        val viewBinding = inflateMethod.invoke(null, thisRef.layoutInflater) as T
        thisRef.setContentView(viewBinding.root)

        return viewBinding.also { this.binding = it }
    }
}