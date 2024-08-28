import io.github.cmsong111.ImgBB
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


import java.io.File

class ImgBBTest {

    private val imageBB = ImgBB("Insert your API key here")

    @Test
    fun uploadImage() {
        val file = File(this.javaClass.getResource("/img/test_image.jpg")!!.file)
        val result = imageBB.uploadImage(file)

        Assertions.assertTrue(result.success!!)
    }
}
