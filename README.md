# Play-Videos-In-HDFS
This project realizes playing videos storing in HDFS(Hadoop) in the web page online.</br>
这个工程实现了在网页中在线播放存储在HDFS(Hadoop)中的视频文件的功能。
# Introduce 介绍
In some existing methods:</br>
WebHDFS/streamFile require that HDFS Clusters be exposed in public network and WebHDFS can't fast forward.</br>
HTTPFS Gateway can't fast forward too.</br>
This Project use web server as a gateway.HDFS Clusters don't need to be exposed in public network and it supports fast forward.</br>
</br>
在已有的一些方式中：</br>
使用WebHDFS/streamFile方式必须将HDFS集群暴露在公网，其中WebHDFS无法快进。</br>
使用HTTPFS GateWay方式无法快进。</br>
本工程使用web服务器作为网关，无需将HDFS集群暴露在公网中，同时实现视频快进。
#Usage 用法
1、Modify the ip address and port in com.constants.Constants.java into the namenode's IP and port.</br>
2、Modify the fpath parameter in http://localhost:8080/HDFSVideoDemo/stream?fpath=/test.mp4 in MyStream.html into the HDFS path of the video file you want to play.</br>
3、Deploy the web project in a web server and start it.</br>
4、Visit http://localhost:8080/HDFSVideoDemo/MyStream.html in a browser.</br>
</br>
1、将com.constants.Constans.java中的ip地址和端口号改为您Hadoop集群中主节点的IP地址以及端口号（默认为9000）。</br>
2、将MyStream.html中video标签中的url：http://localhost:8080/HDFSVideoDemo/stream?fpath=/test.mp4 中的fpath参数改为您Hadoop集群中视频文件的路径。</br>
3、将工程部署在web服务器并启动。</br>
4、访问http://localhost:8080/HDFSVideoDemo/MyStream.html即可。</br>
#Notice 注意事项
1、This project use the new label <video> which now only supports Ogg,MPEG4(MP4),WebM.If you want more video types,try to use another web video player.As the same time,please use the browsers which supports HTML5.</br>
2、This poject supports videos' downloading.Just access the url in video label in browser.</br>
3、This project is a maven project.If you don't use maven,please download the required jars from http://pan.baidu.com/s/1gf33IpH and build the web project yourself.
</br>
1、本工程中前端播放器采用HTML5中新加入的<video>标签，目前只支持Ogg、MPEG4（MP4）、WebM三种格式，若想支持更多格式，请使用换用其他前端播放器，同时请使用支持HTML5的浏览器进行视频播放。</br>
2、本工程支持视频的下载，直接在浏览器中访问MyStream.html中video标签中的URL即可。</br>
3、本工程采用maven构建，如果您不使用maven，可以到 http://pan.baidu.com/s/1gf33IpH 下载相关jar包，自行构建web项目。
#Screenshot 截图
<img src="https://github.com/yeleaveszi/Play-Videos-In-HDFS/blob/master/pic.png"  alt="截图" />
