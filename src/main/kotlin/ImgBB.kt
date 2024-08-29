package io.github.cmsong111

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class ImgBB(
    private val serviceKey: String
) {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgbb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    private val imgbbService = retrofit.create(ImgbbApi::class.java)


    /**
     * Upload an image to the ImgBB API
     * @param image The image to upload
     * @param expiration The time in seconds until the image is deleted if null the image will not be deleted
     * @return The result of the upload
     */
    fun uploadImage(image: File, expiration: Long? = null): ImgbbResult {
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), image)
        val imagePart = MultipartBody.Part.createFormData(
            "image", image.name, requestFile
        )

        if (expiration != null) {
            check(expiration > 0) { "Expiration must be greater than 0" }
            check(expiration <= 15552000) { "Expiration must be less than or equal to 15552000" }
        }

        return imgbbService.uploadImage(
            image = imagePart,
            expiration = expiration,
            key = serviceKey
        ).execute().body()!!
    }
}
