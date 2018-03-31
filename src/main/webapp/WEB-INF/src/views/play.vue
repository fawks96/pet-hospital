//index.vue
<template>
  <el-container>
    <el-header>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>角色扮演</el-breadcrumb-item>
      </el-breadcrumb>
    </el-header>
    <el-main>
      <el-carousel :interval="2000" type="card" class="myCarousel" height="550px" >
        <el-carousel-item v-for="(item, index) in carou" :key="item.title">
          <div class="singleCarousel" >
            <img :src="item.bg" class="carouimg">
            <div v-text="item.title" class="title"></div>
            <div class="btn" v-text="item.btnText" @click="goPlay(item.open)"></div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </el-main>
  </el-container>
</template>

<script>

export default {
  name: 'play',
  data () {
    return {
       carou: [
        {
          title: '前台',
          bg: '../../src/assets/imgs/service.png', // 图片
          open: 'service', // 点击后打开的页面
          btnText: '去扮演' //按钮上的文字
        },
        {
          title: '医生',
          bg: '../../src/assets/imgs/doctor.png', // 图片
          open: 'doctor', // 点击后打开的页面
          btnText: '去扮演' //按钮上的文字
        },
        {
          title: '医助',
          bg: '../../src/assets/imgs/assist.png', // 图片
          open: 'assist', // 点击后打开的页面
          btnText: '去扮演' //按钮上的文字
        }
       ]
    }
  },
  methods:{
    goPlay (role) {
      this.$router.push({name: 'roles', params: { role: role}})
    }
  }
}
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.2.2/lib/theme-chalk/index.css");
.bg {
  margin-top: 50px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  .el-carousel__item{
    background: transparent;
  } 
  .el-carousel__item:nth-child(2n) {
    background: transparent;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background: transparent;
  }
.singleCarousel{
  position: relative;
  width: 100%;
  height: 100%;
  display: flex;
  -webkit-display: flex;
  flex-direction: column;
  -webkit-flex-direction: column;
  align-items: center;
  justify-content: center;
}
.singleCarousel div{
  text-align: center;
}
.singleCarousel .title, .singleCarousel .desc{
  font-size: 40px;
  height: 60px;
  line-height: 60px;
}

.carouimg {
  width: 300px;
  height: auto;
  margin-bottom: 15px;
}
.singleCarousel .btn{
  margin-top: 10px;
  padding: 8px 20px 8px 20px;
  text-align: center;
  border: 1px #fff solid;
  font-size: 28px;
  border-radius: 5px;
  background: #409EFF;
  color: #fff;
}
.singleCarousel .btn:hover{
  color: #000;
  background: #fff;
}
</style>

