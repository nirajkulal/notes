package course.intermediate.notes.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.models.Note

abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        if (holder is BaseButtonViewHolder)
            holder.onBind(Unit)
        else
            (holder as BaseViewHolder<T>).onBind(masterList[pos - 1])
    }

    fun updateData(data: MutableList<T>) {
        masterList.clear()
        masterList.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = masterList.size + 1

    abstract class BaseViewHolder<K>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun onBind(data: K);
    }

    abstract class BaseButtonViewHolder(itemView: View) : BaseViewHolder<Unit>(itemView)

    companion object {
        val TYPE_ADD_BUTTON = 0;
        val TYPE_INFO = 1;
    }

    override fun getItemViewType(position: Int): Int =
        if (position == 0) {
            TYPE_ADD_BUTTON
        } else {
            TYPE_INFO
        }
}