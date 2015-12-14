# Play-Videos-In-HDFS
This project realizes playing videos storing in HDFS(Hadoop) in the web page online.</br>
这个工程实现了在网页中在线播放存储在HDFS(Hadoop)中的视频文件的功能。
# Introduce 介绍
在已有的一些方式中：</br>
使用WebHDFS/streamFile方式必须将HDFS集群暴露在公网，其中WebHDFS无法快进。</br>
使用HTTPFS GateWay方式无法快进。</br>
本工程使用web服务器作为网管，无需将HDFS集群暴露在公网中，同时实现视频快进。
#Usage 用法
1、将com.constants.Constans.java中的ip地址和端口号改为您Hadoop集群中主节点的IP地址以及端口号（默认为9000）。</br>
2、将MyStream.html中video标签中的url：http://localhost:8080/HDFSVideoDemo/stream?fpath=/test.mp4 中的fpath参数改为您Hadoop集群中视频文件的路径。</br>
3、将工程部署在web服务器并启动。</br>
4、访问http://localhost:8080/HDFSVideoDemo/MyStream.html即可。</br>
#Notice 注意事项
1、本工程中前端播放器采用HTML5中新加入的video标签，目前只支持Ogg、MPEG4（MP4）、WebM三种格式，若想支持更多格式，请使用换用其他前端播放器，同时请使用支持HTML5的浏览器进行视频播放。</br>
2、本工程支持视频的下载，直接在浏览器中访问MyStream.html中video标签中的URL即可。
