package ru.mgkit.event.game.objects

import android.widget.TextView

interface Displayable {

    val displayName: String

}

infix fun Displayable.to(view: TextView) {
    view.text = displayName
}

infix fun TextView.text(displayable: Displayable) {
    text = displayable.displayName
}