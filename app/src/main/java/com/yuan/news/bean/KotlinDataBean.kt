package com.yuan.news.bean

/**
 *yuan
 *2020/1/30
 **/

/**
 * {
"code": 200,
"msg": "OK",
"muser": [
{
"name": "zhangsan",
"age": "10",
"phone": "11111",
"email": "11111@11.com"
},
{
"name": "lisi",
"age": "20",
"phone": "22222",
"email": "22222@22.com"
},
...
]
}
 */
//data class KotlinDataBean (val code: Int, val msg: String, val muser: List<UserBean>)

//data class UserBean(val name: String, val age: String, val phone: String, val email: String)


/**
 * reason : 成功的返回
 * result : {"stat":"1","data":[{"uniquekey":"fa6beb2fdd703cfb1ef3ddeeb8cc4a26","title":"滦州市范庄村：90名共产党员组\u201c战队\u201d奋战防疫一线","date":"2020-01-30 20:54","category":"头条","author_name":"长城网唐山频道","url":"http://mini.eastday.com/mobile/200130205400768.html","thumbnail_pic_s":"http://02imgmini.eastday.com/mobile/20200130/20200130205400_f4857259c92578926bc9637e6e3fe740_1_mwpm_03200403.jpg"}]}
 * error_code : 0
 */
data class KotlinDataBean(val reason: String, val result: ResultBean, val error_code: Int)

/**
 * stat : 1
 * data : [{"uniquekey":"fa6beb2fdd703cfb1ef3ddeeb8cc4a26","title":"滦州市范庄村：90名共产党员组\u201c战队\u201d奋战防疫一线","date":"2020-01-30 20:54","category":"头条","author_name":"长城网唐山频道","url":"http://mini.eastday.com/mobile/200130205400768.html","thumbnail_pic_s":"http://02imgmini.eastday.com/mobile/20200130/20200130205400_f4857259c92578926bc9637e6e3fe740_1_mwpm_03200403.jpg"}]
 */

data class ResultBean(val stat: String, val data: List<DataBean>)

/**
 * uniquekey : fa6beb2fdd703cfb1ef3ddeeb8cc4a26
 * title : 滦州市范庄村：90名共产党员组“战队”奋战防疫一线
 * date : 2020-01-30 20:54
 * category : 头条
 * author_name : 长城网唐山频道
 * url : http://mini.eastday.com/mobile/200130205400768.html
 * thumbnail_pic_s : http://02imgmini.eastday.com/mobile/20200130/20200130205400_f4857259c92578926bc9637e6e3fe740_1_mwpm_03200403.jpg
 */
data class DataBean(val uniquekey: String, val title: String, val date: String, val category: String,
                    val author_name: String, val url: String, val thumbnail_pic_s: String, val thumbnail_pic_s02: String, val thumbnail_pic_s03: String)