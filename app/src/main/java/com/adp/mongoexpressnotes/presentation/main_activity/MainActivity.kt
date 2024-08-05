package com.adp.mongoexpressnotes.presentation.main_activity

import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.presentation.navhost.SetupNavHost
import com.adp.mongoexpressnotes.presentation.ui.theme.MongoExpressNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)

//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.dark(
////                android.graphics.Color.TRANSPARENT
//                Color(0xFF03045E).toArgb()
//            ),
//            navigationBarStyle = SystemBarStyle.dark(
//                android.graphics.Color.TRANSPARENT
//            )
//        )
        WindowCompat.setDecorFitsSystemWindows(window, false)

//        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, windowInsets ->
//            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
//            // Apply the insets as a margin to the view. This solution sets
//            // only the bottom, left, and right dimensions, but you can apply whichever
//            // insets are appropriate to your layout. You can also update the view padding
//            // if that's more appropriate.
//            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
//                leftMargin = insets.left;
//                bottomMargin = insets.bottom;
//                rightMargin = insets.right;
//            }
//
//            // Return CONSUMED if you don't want want the window insets to keep passing
//            // down to descendant views.
//            WindowInsetsCompat.CONSUMED
//        }
        installSplashScreen()
        setContent {
            MongoExpressNotesTheme {
                val colorList = listOf(
//                    colorResource(id = R.color.a), // #000000
                    colorResource(id = R.color.b), // #080808
                    colorResource(id = R.color.c), // #101010
                    colorResource(id = R.color.d), // #181818
                    colorResource(id = R.color.e), // #202020
                    colorResource(id = R.color.f), // #282828
                    colorResource(id = R.color.g), // #303030
                    colorResource(id = R.color.h), // #383838
                    colorResource(id = R.color.g), // #303030
                    colorResource(id = R.color.f), // #282828
                    colorResource(id = R.color.e), // #202020
                    colorResource(id = R.color.d), // #181818
                    colorResource(id = R.color.c), // #101010
                    colorResource(id = R.color.b), // #080808
//                    colorResource(id = R.color.a)  // #000000

//                    colorResource(id = R.color.i), // #404040
//                    colorResource(id = R.color.j), // #484848
//                    colorResource(id = R.color.k), // #505050
//                    colorResource(id = R.color.l), // #585858
//                    colorResource(id = R.color.m), // #606060
//                    colorResource(id = R.color.n), // #686868
//                    colorResource(id = R.color.o), // #707070
//                    colorResource(id = R.color.p), // #787878
//                    colorResource(id = R.color.q), // #808080
//                    colorResource(id = R.color.r), // #888888
//                    colorResource(id = R.color.s), // #909090
//                    colorResource(id = R.color.t), // #989898
//                    colorResource(id = R.color.u), // #A0A0A0
//                    colorResource(id = R.color.v), // #A8A8A8
//                    colorResource(id = R.color.w), // #B0B0B0
//                    colorResource(id = R.color.x), // #B8B8B8
//                    colorResource(id = R.color.y), // #C0C0C0
//                    colorResource(id = R.color.z), // #C8C8C8
//                    colorResource(id = R.color.aa), // #D0D0D0
//                    colorResource(id = R.color.ab), // #D8D8D8
//                    colorResource(id = R.color.ac), // #E0E0E0
//                    colorResource(id = R.color.ad), // #E8E8E8
//                    colorResource(id = R.color.ae), // #F0F0F0
//                    colorResource(id = R.color.af), // #F8F8F8
//                    colorResource(id = R.color.ag)  // #FFFFFF
                )
//                val colorList = listOf(
//                    colorResource(id = R.color.a), // #000000
//                    colorResource(id = R.color.b), // #080808
//                    colorResource(id = R.color.c), // #101010
//                    colorResource(id = R.color.d), // #181818
//                    colorResource(id = R.color.e), // #202020
//                    colorResource(id = R.color.f), // #282828
//                    colorResource(id = R.color.g), // #303030
//                    colorResource(id = R.color.h), // #383838
//                    colorResource(id = R.color.i), // #404040
//                    colorResource(id = R.color.j), // #484848
//                    colorResource(id = R.color.k), // #505050
//                    colorResource(id = R.color.l), // #585858
//                    colorResource(id = R.color.m), // #606060
//                    colorResource(id = R.color.n), // #686868
//                    colorResource(id = R.color.o), // #707070
//                    colorResource(id = R.color.p), // #787878
//                    colorResource(id = R.color.q), // #808080
//                    colorResource(id = R.color.r), // #888888
//                    colorResource(id = R.color.s), // #909090
//                    colorResource(id = R.color.t), // #989898
//                    colorResource(id = R.color.u), // #A0A0A0
//                    colorResource(id = R.color.v), // #A8A8A8
//                    colorResource(id = R.color.w), // #B0B0B0
//                    colorResource(id = R.color.x), // #B8B8B8
//                    colorResource(id = R.color.y), // #C0C0C0
//                    colorResource(id = R.color.z), // #C8C8C8
//                    colorResource(id = R.color.aa), // #D0D0D0
//                    colorResource(id = R.color.ab), // #D8D8D8
//                    colorResource(id = R.color.ac), // #E0E0E0
//                    colorResource(id = R.color.ad), // #E8E8E8
//                    colorResource(id = R.color.ae), // #F0F0F0
//                    colorResource(id = R.color.af), // #F8F8F8
//                    colorResource(id = R.color.ag)  // #FFFFFF
//                )

//                val colorList = listOf(
//                    colorResource(id = R.color.ag), // #FFFFFF
//                    colorResource(id = R.color.af), // #F8F8F8
//                    colorResource(id = R.color.ae), // #F0F0F0
//                    colorResource(id = R.color.ad), // #E8E8E8
//                    colorResource(id = R.color.ac), // #E0E0E0
//                    colorResource(id = R.color.ab), // #D8D8D8
//                    colorResource(id = R.color.aa), // #D0D0D0
//                    colorResource(id = R.color.z), // #C8C8C8
//                    colorResource(id = R.color.y), // #C0C0C0
//                    colorResource(id = R.color.x), // #B8B8B8
//                    colorResource(id = R.color.w), // #B0B0B0
//                    colorResource(id = R.color.v), // #A8A8A8
//                    colorResource(id = R.color.u), // #A0A0A0
//                    colorResource(id = R.color.t), // #989898
//                    colorResource(id = R.color.s), // #909090
//                    colorResource(id = R.color.r), // #888888
//                    colorResource(id = R.color.q), // #808080
//                    colorResource(id = R.color.p), // #787878
//                    colorResource(id = R.color.o), // #707070
//                    colorResource(id = R.color.n), // #686868
//                    colorResource(id = R.color.m), // #606060
//                    colorResource(id = R.color.l), // #585858
//                    colorResource(id = R.color.k), // #505050
//                    colorResource(id = R.color.j), // #484848
//                    colorResource(id = R.color.i), // #404040
//                    colorResource(id = R.color.h), // #383838
//                    colorResource(id = R.color.g), // #303030
//                    colorResource(id = R.color.f), // #282828
//                    colorResource(id = R.color.e), // #202020
//                    colorResource(id = R.color.d), // #181818
//                    colorResource(id = R.color.c), // #101010
//                    colorResource(id = R.color.b), // #080808
//                    colorResource(id = R.color.a)  // #000000
//                )


                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.verticalGradient(colorList))
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                ){
                    SetupNavHost()
                }
            }
        }
    }
}
