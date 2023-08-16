package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * @param inlineKeyboard Array of button rows, each represented by an Array of [InlineKeyboardButton] objects.
 * @see <https://core.telegram.org/bots/api#inlinekeyboardmarkup>
 */
data class InlineKeyboardMarkup internal constructor(
    val inline_keyboard: List<List<InlineKeyboardButton>>,
) : ReplyMarkup {

    init {
        validatePriorityButtonsForType<InlineKeyboardButton.Pay>()
        validatePriorityButtonsForType<InlineKeyboardButton.CallbackGameButtonType>()
    }

    // Priority buttons must always be the first button in the first row.
    private inline fun <reified T> validatePriorityButtonsForType() {
        val flattenedButtons = inline_keyboard.flatten()
        val filteredButtons = flattenedButtons.filterIsInstance<T>()
        val typeName = T::class.simpleName

        require(filteredButtons.size <= 1) {
            "Can't have more than one button of type $typeName per inline keyboard"
        }

        require(filteredButtons.size != 1 || flattenedButtons.firstOrNull() is T) {
            "Buttons of type $typeName must always be the first button in the first row"
        }
    }
}
