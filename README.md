# ImgBB Unofficial Java SDK

This is an unofficial Java SDK for the [ImgBB](https://imgbb.com) API. 
It provides a simple way to interact with the ImgBB API using Java.


## Installation

Add Dependency to your `gradle.build` file:

```gradle
dependencies {
    implementation 'io.github.cmsong111:imgbb-unofficial:0.0.1'
}
```

## Usage

### Upload Image

```kotlin
import io.github.cmsong111.ImgBB;

public void example() {
    val key = "INPUT_YOUR_API_KEY"
    val imageBB = ImgBB(key)
    
    val image = File("path/to/image.jpg")

    val result = imageBB.uploadImage(file)
}
```

### Parameters

- `file`: The image file to upload.
  - The image file. under 32MB.
- `name`: The name of the image file.
  -  Use the original file name.
- `expiration`: The time in seconds to keep the image on the server.
  - 0 ~ 15552000 (180 days)
  - null is not expired.

