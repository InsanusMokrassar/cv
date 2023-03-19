package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.containers.AnchorContainer
import dev.inmo.resume.common.models.Me
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

class MeDrawer(
    private val me: Me
) : Drawer {
    @Composable
    override fun invoke() {
        AnchorContainer(
            rightBuilder = {

            }
        ) {
            H2 {
                Text(me.name)
            }

            P()
            Span {
                B { Text("Birthday:") }
                Span { Text(" ") }
                Text(me.birthday)
            }

            P()
            Span {
                B { Text("Phone:") }
                Span { Text(" ") }
                A("tel:${me.phoneNumber}") { Text(me.phoneText) }
            }

            P()
            Span {
                B { Text("E-Mail:") }
                Span { Text(" ") }
                A("mailto:${me.email}") { Text(me.email) }
            }
        }
    }
}
