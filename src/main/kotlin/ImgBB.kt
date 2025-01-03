package io.github.cmsong111

import java.io.File
import java.util.concurrent.TimeUnit
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * An unofficial ImgBB API client for Kotlin
 *
 * @param serviceKey The ImgBB API key
 * @param timeout The timeout for the HTTP client (Minutes)
 */
class ImgBB(
    private val serviceKey: String,
    private val timeout: Long = 1
) {
    // http timeout for 1min
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(timeout, TimeUnit.MINUTES)
        .readTimeout(timeout, TimeUnit.MINUTES)
        .writeTimeout(timeout, TimeUnit.MINUTES)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgbb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val imgBBService = retrofit.create(ImgBBApi::class.java)


    /**
     * Upload an image to the ImgBB API
     * @param image The image to upload (under 32MB)
     * @param expiration The time in seconds until the image is deleted if null the image will not be deleted
     * @param name The name of the image(optional: if null the name of the file will be used)
     * @return The result of the upload
     */
    fun uploadImage(image: File, name: String? = null, expiration: Long? = null): ImgBBResult {
        val requestFile = image.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData(
            "image", image.name, requestFile
        )

        // Check File Size
        check(image.length() <= 32 * 1024 * 1024) { "File size must be less than or equal to 32MB" }


        // Check expiration
        if (expiration != null) {
            check(expiration > 0) { "Expiration must be greater than 0" }
            check(expiration <= 15552000) { "Expiration must be less than or equal to 15552000" }
        }

        return imgBBService.uploadImage(
            image = imagePart,
            expiration = expiration,
            key = serviceKey,
            name = name
        ).execute().body()!!
    }
}
