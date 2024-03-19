package com.example.descuentosapp.views

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.unit.dp
import androidx.test.runner.AndroidJUnit4
import com.example.descuentosapp.MainActivity
import com.example.descuentosapp.views.viewmodel.CalcularViewModel3
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeView3Test {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    //val composeRule = createComposeRule()
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun whenStart_showAppBarTitle() {
        composeRule.activity.setContent {
            val viewModel3 = composeRule.activity.viewModels<CalcularViewModel3>().value
            HomeView3(viewModel = viewModel3)
        }

        composeRule.onNodeWithTag("titleAppBar").assertIsDisplayed()
    }

    @Test
    fun whenFieldsEmpty_ShowDialog() {
        composeRule.activity.setContent {
            val viewModel3 = composeRule.activity.viewModels<CalcularViewModel3>().value
            ContentHomeView3(paddingValues = PaddingValues(8.dp), viewModel = viewModel3)
        }

        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()
    }

    @Test
    fun whenFieldPriceIsEmpty_ShowDialog() {
        composeRule.activity.setContent {
            val viewModel3 = composeRule.activity.viewModels<CalcularViewModel3>().value
            ContentHomeView3(paddingValues = PaddingValues(8.dp), viewModel = viewModel3)
        }

        composeRule.onNodeWithTag("fieldPrecio").performTextReplacement("100")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()
    }

    @Test
    fun whenFieldDiscIsEmpty_ShowDialog() {
        composeRule.activity.setContent {
            val viewModel3 = composeRule.activity.viewModels<CalcularViewModel3>().value
            ContentHomeView3(paddingValues = PaddingValues(8.dp), viewModel = viewModel3)
        }

        composeRule.onNodeWithTag("fieldDescuento").performTextReplacement("10")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()
    }

    @Test
    fun whenFieldsNotEmpty_notShowDialogAndSuccess() {
        composeRule.activity.setContent {
            val viewModel3 = composeRule.activity.viewModels<CalcularViewModel3>().value
            ContentHomeView3(paddingValues = PaddingValues(8.dp), viewModel = viewModel3)
        }

        //Probar campos vacios
        composeRule.onNodeWithTag("fieldPrecio").performTextReplacement("")
        composeRule.onNodeWithTag("fieldDescuento").performTextReplacement("")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()

        //Probar campos precio vacio
        composeRule.onNodeWithTag("fieldPrecio").performTextReplacement("")
        composeRule.onNodeWithTag("fieldDescuento").performTextReplacement("10")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()

        //Probar campos descuento vacio
        composeRule.onNodeWithTag("fieldPrecio").performTextReplacement("100")
        composeRule.onNodeWithTag("fieldDescuento").performTextReplacement("")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertIsDisplayed()
        composeRule.onNodeWithTag("btnAcceptDialog").performClick()

        //Probar success
        composeRule.onNodeWithTag("fieldPrecio").performTextReplacement("100")
        composeRule.onNodeWithTag("fieldDescuento").performTextReplacement("10")
        composeRule.onNodeWithTag("btnGenerar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertDoesNotExist()
        composeRule.onNodeWithTag("total").assertTextEquals("$90.0")
        composeRule.onNodeWithTag("descuento").assertTextEquals("$10.0")
        composeRule.onNodeWithTag("btnLimpiar").performClick()
        composeRule.onNodeWithTag("alertCamposVacios").assertDoesNotExist()
        composeRule.onNodeWithTag("fieldPrecio").assert(hasText(""))
        composeRule.onNodeWithTag("fieldDescuento").assert(hasText(""))
        composeRule.onNodeWithTag("total").assertTextEquals("$0.0")
        composeRule.onNodeWithTag("descuento").assertTextEquals("$0.0")
    }

}