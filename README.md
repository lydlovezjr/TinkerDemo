# TinkerDemo
Tinker热修复</br>
第一步:集成</br>
第二步:正常打包,生成基准包</br>
第三步:替换tinkerpatch.gradle中def baseInfo = "app-1.0.0-0803-11-56-37"为app/build/bakApk目录下的名字</br>
第四步:执行gradlew tinkerPatchRelease命令 打补丁包 </br>
第五步:发布补丁包</br>
