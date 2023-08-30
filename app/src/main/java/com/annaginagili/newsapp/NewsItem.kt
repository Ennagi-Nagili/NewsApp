package com.annaginagili.newsapp

import android.net.Uri

class NewsItem {
    var image: Uri? = null
    var name: String? = null
    var time: String? = null
    var creator: List<String>? = null

    companion object {
        fun getData(imageList: ArrayList<Uri>, nameList: ArrayList<String>, timeList: ArrayList<String>,
                    creatorList: ArrayList<List<String>>): ArrayList<NewsItem> {
            val itemList = ArrayList<NewsItem>()
            for (i in 0 until imageList.size) {
                val item = NewsItem()
                item.image = imageList[i]
                item.name = nameList[i]
                item.time = timeList[i]
                item.creator = creatorList[i]
                itemList.add(item)
            }
            return itemList
        }
    }
}