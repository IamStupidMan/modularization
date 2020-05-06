#!/bin/sh
# 该脚本使用方法
# 思路来源：https://github.com/stackhou/AutoPacking-iOS
# step 1. 在工程根目录新建文件autopacking.sh，将该脚本复制到autopacking.sh文件并保存(或者直接复制该文件);
# step 2. 设置该脚本;
# step 2. cd 该脚本目录，运行chmod +x AutoPackingAndroid.sh;
# step 3. 终端运行 sh AutoPackingAndroid.sh;

# ************************* 配置 Start ********************************

# 【配置上传到蒲公英相关信息】(可选)
#__PGYER_U_KEY="蒲公英的User Key "
#__PGYER_API_KEY="蒲公英的API Key"

# 换行符
__LINE_BREAK_LEFT="\n\033[32;1m*********"
__LINE_BREAK_RIGHT="***************\033[0m\n"
__SLEEP_TIME=0.3

# 指定打包编译的模式，如：Release, Debug...
echo "\033[36;1m请选择 打包编译模式 (输入序号, 按回车即可) \033[0m"
echo "\033[33;1m1. Debug \033[0m"
echo "\033[33;1m2. Release \033[0m"
echo "\033[33;1m3. All \033[0m"

read parameter
sleep ${__SLEEP_TIME}
__BUILD_CONFIGURATION_SELECTED="${parameter}"

 判读用户是否有输入
if [ "${__BUILD_CONFIGURATION_SELECTED}" = "1" ]; then
__BUILD_CONFIGURATION="Debug"
elif [ "${__BUILD_CONFIGURATION_SELECTED}" = "2" ]; then
__BUILD_CONFIGURATION="Release"
else
__BUILD_CONFIGURATION="Debug"
fi
# ************************* 基础END ********************************

# ************************* 蒲公英START *****************************
#if [[ "${__BUILD_CONFIGURATION_SELECTED}" != "1" ]]; then
## 选择内测网站 用pgyer
#echo "\033[36;1m请选择apk内测发布平台 (输入序号, 按回车即可) \033[0m"
#echo "\033[33;1m1. None \033[0m"
#echo "\033[33;1m2. Pgyer \033[0m"
#
## 读取用户输入并存到变量里
#read parameter
#sleep ${__SLEEP_TIME}
#__UPLOAD_TYPE_SELECTED="${parameter}"
#
#if [[ "${__UPLOAD_TYPE_SELECTED}" == "2" ]]; then
## 【配置上传到蒲公英的productFlavor】
#echo "\033[36;1m请选择要上传到蒲公英的productFlavor (输入序号, 按回车即可) \033[0m"
#echo "\033[33;1m1. PGY \033[0m"
#echo "\033[33;1m2. huawei \033[0m"
#echo "\033[33;1m3. xiaomi \033[0m"
#
#read parameter
#sleep ${__SLEEP_TIME}
#__FLAVOR_NAME_SELECTED="${parameter}"
#
#if [[ "${__FLAVOR_NAME_SELECTED}" == "1" ]]; then
#__FLAVOR_NAME="PGY"
#elif [[ "${__FLAVOR_NAME_SELECTED}" == "2" ]]; then
#__FLAVOR_NAME="huawei"
#elif [[ "${__FLAVOR_NAME_SELECTED}" == "3" ]]; then
#__FLAVOR_NAME="xiaomi"
#else
#echo "${__LINE_BREAK_LEFT} 您输入 productFlavor 参数无效!!! ${__LINE_BREAK_RIGHT}"
#exit 1
#fi
## 如果上传蒲公英需要填写更新内容
#echo "\033[36;1m上传蒲公英需要填写本次更新说明(输入简单的更新说明, 按回车即可) \033[0m"
## 读取用户输入并存到变量里
#read parameter
#sleep ${__SLEEP_TIME}
#__UPLOAD_PGY_REMARK_CONTENT="${parameter}"
#fi
#if test -z "${__UPLOAD_PGY_REMARK_CONTENT}"
#then
#__UPLOAD_PGY_REMARK_CONTENT="默认的更新说明。。"
#fi
#fi
# ************************* 蒲公英END *****************************
# 成功出包后是否自动打开文件夹
echo "\033[36;1m成功出包后是否自动打开文件夹(输入序号, 按回车即可) \033[0m"
echo "\033[33;1m1. 是 \033[0m"
echo "\033[33;1m2. 否 \033[0m"

read parameter
sleep ${__SLEEP_TIME}
__IS_AUTO_OPENT_FILE_SELECTED="${parameter}"

# 判读用户是否有输入
if [ "${__IS_AUTO_OPENT_FILE_SELECTED}" = "1" ]; then
__IS_AUTO_OPENT_FILE=true
elif [ "${__IS_AUTO_OPENT_FILE_SELECTED}" = "2" ]; then
__IS_AUTO_OPENT_FILE=false
else
echo "${__LINE_BREAK_LEFT} 您输入的成功出包后是否自动打开文件夹 参数错误!!! ${__LINE_BREAK_RIGHT}"
exit 1
fi

# 完毕是否开始打包
echo "\033[36;1m设置完毕是否开始打包 (输入序号, 按回车即可) \033[0m"
echo "\033[33;1m1. 是 \033[0m"
echo "\033[33;1m2. 退出 \033[0m"

read parameter
sleep ${__SLEEP_TIME}
__IS_START_PACKINF="${parameter}"

# 判读用户是否有输入
if [ "${__IS_START_PACKINF}" = "1" ]; then
echo "${__LINE_BREAK_LEFT} 立即开始 ${__LINE_BREAK_RIGHT}"
elif [ "${__IS_START_PACKINF}" = "2" ]; then
echo "${__LINE_BREAK_LEFT} 您退出了打包 ${__LINE_BREAK_RIGHT}"
exit 1
else
echo "${__LINE_BREAK_LEFT} 您输入 是否立即开始打包 参数无效!!! 退出程序 ${__LINE_BREAK_RIGHT}"
exit 1
fi
# ===============================自动打包部分=============================
echo "${__LINE_BREAK_LEFT} 开始打包。。。。。。。。。。。 ${__LINE_BREAK_RIGHT}"
# 打包计时
__CONSUME_TIME=0

# 进入到工程的应用目录 app
cd app
__PROGECT_APP_PATH=`pwd`
echo "${__LINE_BREAK_LEFT} 进入应用目录=${__PROGECT_APP_PATH} ${__LINE_BREAK_RIGHT}"

# 获取版本号 printVersionName 自定义的gradle任务，打印VersionName的
__BUNDLE_VERSION=`gradle -q printVersionName`

# 打印版本信息
echo "${__LINE_BREAK_LEFT} 打包版本=${__BUNDLE_VERSION}  ${__LINE_BREAK_RIGHT}"

# 获取时间 如:201706011145
__CURRENT_DATE="$(date +%Y%m%d_%H%M%S)"

# 第一步 clean项目
echo "${__LINE_BREAK_LEFT} 开始clean项目 ${__LINE_BREAK_RIGHT}"
gradle clean

# 第二步 打包
if [ "${__BUILD_CONFIGURATION}" = "Debug" ]; then
# debug打包
echo "${__LINE_BREAK_LEFT} 开始打包项目，当前打包Debug版本 ${__LINE_BREAK_RIGHT}"
gradle assembleDebug
elif [ "${__BUILD_CONFIGURATION}" = "Release" ]; then
# release打包
echo "${__LINE_BREAK_LEFT} 开始打包项目，当前打包Release版本 ${__LINE_BREAK_RIGHT}"
gradle assembleRelease
else
# build是两个一起打包
echo "${__LINE_BREAK_LEFT} 开始打包项目，当前打包全部版本 ${__LINE_BREAK_RIGHT}"
gradle build
fi

# 检查是否打包成功 build 下面的apk目录是否存在
if test -d "${__PROGECT_APP_PATH}/build/outputs/apk" ; then
echo "${__LINE_BREAK_LEFT} 项目构建成功 🚀 🚀 🚀 ${__LINE_BREAK_RIGHT}"
else
echo "${__LINE_BREAK_LEFT} 项目构建失败 😢 😢 😢 ${__LINE_BREAK_RIGHT}"
exit 1
fi
# 把打好包的apk文件放到archive归档目录
echo "${__LINE_BREAK_LEFT} 开始导出apk文件 ${__LINE_BREAK_RIGHT}"
__EXPORT_APK_PATH="./archive"
if test -d "${__EXPORT_APK_PATH}" ; then
echo "${__LINE_BREAK_LEFT} 保存归档文件的路径=${__EXPORT_APK_PATH} ${__LINE_BREAK_RIGHT}"
rm -rf ${__EXPORT_APK_PATH}/*
else
mkdir -pv ${__EXPORT_APK_PATH}
fi
# 把outputs里面的apk目录整个搬过来
mv ${__PROGECT_APP_PATH}/build/outputs/apk/* ${__EXPORT_APK_PATH}/


# 上传蒲公英
#if test -n "${__UPLOAD_TYPE_SELECTED}"
#then
#
#if [[ "${__UPLOAD_TYPE_SELECTED}" == "2" ]]; then
#
## 检查文件是否存在
#if test -e "${__EXPORT_APK_PATH}/${__FLAVOR_NAME}/release/${__FLAVOR_NAME}-${__BUNDLE_VERSION}.apk" ; then
#curl -F "file=@${__EXPORT_APK_PATH}/${__FLAVOR_NAME}/release/${__FLAVOR_NAME}-${__BUNDLE_VERSION}.apk" \
#-F "uKey=$__PGYER_U_KEY" \
#-F "_api_key=$__PGYER_API_KEY" \
#-F "updateDescription=$__UPLOAD_PGY_REMARK_CONTENT" \
#"http://www.pgyer.com/apiv1/app/upload"
#echo "${__LINE_BREAK_LEFT} 上传 ${__FLAVOR_NAME}-${__BUNDLE_VERSION}.apk 包 到 pgyer 成功 🎉 🎉 🎉 ${__LINE_BREAK_RIGHT}"
#else
#echo "${__LINE_BREAK_LEFT} apk文件路径不正确。。。 ${__LINE_BREAK_RIGHT}"
#exit 1
#fi
#
#else
#echo "${__LINE_BREAK_LEFT} 您输入 上传内测网站 参数无效!!! ${__LINE_BREAK_RIGHT}"
#fi
#
#else
#echo "${__LINE_BREAK_LEFT} 不需要上传发布网站！！！ ${__LINE_BREAK_RIGHT}"
#fi

# 自动打开文件夹
if ${__IS_AUTO_OPENT_FILE} ; then
open ${__EXPORT_APK_PATH}
fi

# 输出打包总用时
echo "${__LINE_BREAK_LEFT} 使用Shell脚本打包总耗时: ${SECONDS}s ${__LINE_BREAK_RIGHT}"