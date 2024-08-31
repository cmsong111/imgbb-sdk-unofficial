package io.github.cmsong111

import com.google.gson.annotations.SerializedName

data class ImgBBResult(

    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("status") var status: Int? = null

)

data class Image(

    @SerializedName("filename") var filename: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("extension") var extension: String? = null,
    @SerializedName("url") var url: String? = null

)

data class Thumb(

    @SerializedName("filename") var filename: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("extension") var extension: String? = null,
    @SerializedName("url") var url: String? = null

)

data class Medium(

    @SerializedName("filename") var filename: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("mime") var mime: String? = null,
    @SerializedName("extension") var extension: String? = null,
    @SerializedName("url") var url: String? = null

)

data class Data(

    @SerializedName("id") var id: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url_viewer") var urlViewer: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("display_url") var displayUrl: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("size") var size: Int? = null,
    @SerializedName("time") var time: Int? = null,
    @SerializedName("expiration") var expiration: Int? = null,
    @SerializedName("image") var image: Image? = Image(),
    @SerializedName("thumb") var thumb: Thumb? = Thumb(),
    @SerializedName("medium") var medium: Medium? = Medium(),
    @SerializedName("delete_url") var deleteUrl: String? = null

)
