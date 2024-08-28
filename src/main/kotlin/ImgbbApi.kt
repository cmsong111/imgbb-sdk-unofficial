package io.github.cmsong111


import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ImgbbApi {
    /**
     * Upload an image to the ImgBB API
     * @param image The image to upload
     * @param expiration The time in seconds until the image is deleted if null the image will not be deleted
     */
    @Multipart
    @POST("/1/upload")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Query("expiration") expiration: Long?,
        @Query("key") key: String
    ): Call<ImgbbResult>
}
