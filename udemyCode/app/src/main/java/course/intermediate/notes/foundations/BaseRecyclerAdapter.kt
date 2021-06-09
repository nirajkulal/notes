package course.intermediate.notes.foundations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        if (holder is BaseButtonViewHolder)
            holder.onBind(Unit, 0)
        else
            (holder as BaseViewHolder<T>).onBind(masterList[pos - 1], (pos - 1))
    }

    fun updateData(data: MutableList<T>) {
        var result = DiffUtil.calculateDiff(DiffUtilCallback(masterList,data))
        masterList.clear()
        masterList.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = masterList.size + 1

    abstract class BaseViewHolder<K>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun onBind(data: K, listIndex: Int)
    }

    abstract class BaseButtonViewHolder(itemView: View) : BaseViewHolder<Unit>(itemView)

    companion object {
        val TYPE_ADD_BUTTON = 0
        val TYPE_INFO = 1
    }

    override fun getItemViewType(position: Int): Int =
        if (position == 0) {
            TYPE_ADD_BUTTON
        } else {
            TYPE_INFO
        }

    class DiffUtilCallback<T>(
        val oldList: List<T>,
        val newList: List<T>
    ) : DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return  (oldList[oldItemPosition] == newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return  (oldList[oldItemPosition] == newList[newItemPosition])
        }

    }
}