package com.hfad.applicforless4.view.adapter

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition:Int,toPosition:Int)
    fun onItemDismiss(position:Int)
}
interface ItemTouchHelperViewHolder {
    fun onItemSelected()
    fun onItemClear()
}