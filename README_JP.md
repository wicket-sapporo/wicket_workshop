Wicket Workshop
================

##はじめに

これは[Apache Wicket](http://wicket.apache.org/)を利用したサンプルWebアプリケーションです。  
このプロジェクトを実行するためには、JDK7およびMaven3が動作する環境が必要です。

プロジェクトを動作させるには、コンソールから以下のMavenコマンドを実行してください。

	$ mvn jetty:run

## 内容
このプロジェクトは、北海道のApache Wicketユーザコミュニティである[Wicket-Sapporo](http://wicket-sapporo.org/)が2013年9月から11月に開催したApache Wicket勉強会用のサンプルプログラムです。  
この勉強会のテキストはWicket-Sapporoのホームページで公開されていますので、併せてご確認ください。

なお、

- 基本的なWicketアプリケーション
- GoogleGuiceと連係したWicketアプリケーション
- Springと連係したWicketアプリケーション

が動作するように作られています。


## 注意
このプロジェクトはDIコンテナを利用しているため、PermGen領域のOutOfMemoryErrorが発生する可能性があります。  
その場合には、MaxPermSizeなどを実行環境のオプションに設定してください。例えば以下の様な形です。

	$ export MAVEN_OPTS="-XX:MaxPermSize=128m"
