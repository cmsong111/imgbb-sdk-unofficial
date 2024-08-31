import io.github.cmsong111.ImgBB
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


import java.io.File

class ImgBBTest {
    /**
     * Set the IMGBB_API_KEY environment variable to your ImgBB API key
     */
    private val key = System.getenv("IMGBB_API_KEY")
    private val imageBB = ImgBB(key)

    @Test
    fun uploadImage() {

        val file = File(this.javaClass.getResource("/img/test_image.jpg")!!.file)
        val result = imageBB.uploadImage(file)

        Assertions.assertTrue(result.success!!)

        println(result)
    }

    @Test
    fun uploadImageWithWrongExpiration() {
        val file = File(this.javaClass.getResource("/img/test_image.jpg")!!.file)

        Assertions.assertThrows(IllegalStateException::class.java) {
            imageBB.uploadImage(
                image = file,
                expiration = -1
            )
        }
    }

    @Test
    fun uploadImageWithName() {
        val file = File(this.javaClass.getResource("/img/test_image.jpg")!!.file)
        val result = imageBB.uploadImage(
            image = file,
            name = "test_test_test.jpg"
        )

        Assertions.assertTrue(result.success!!)
    }
}
