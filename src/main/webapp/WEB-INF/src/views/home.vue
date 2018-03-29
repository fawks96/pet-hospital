//index.vue
<template>
  <div class="bg">
    <div class="single" v-for="(item, index) in carou">
      <h2 style=" font-family: 'PingFang SC';color: #026660;">{{item.title}}</h2>
      <h4>{{item.desc}}</h4>
      <el-button type="primary">{{item.btnText}}</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: 'home',
  data () {
    return {
       carou: [
        {
          title: '导览展示',
          desc: '以3D模型分科室详尽的展示宠物医院',
          bg: '', // 图片
          open: '', // 点击后打开的页面
          btnText: '去体验' //按钮上的文字
        },
        {
          title: '角色扮演',
          desc: '扮演前台、医助、医师,了解各个职位',
          bg: '', // 图片
          open: '', // 点击后打开的页面
          btnText: '去扮演' //按钮上的文字
        },
        {
          title: '病例学习',
          desc: '这里有最丰富最全面的宠物病例',
          bg: '', // 图片
          open: '', // 点击后打开的页面
          btnText: '去学习' //按钮上的文字
        },
        {
          title: '测试',
          desc: '对您的学习情况进行阶段性的测试',
          bg: '', // 图片
          open: '', // 点击后打开的页面
          btnText: '去测试' //按钮上的文字
        }
       ]
    }
  },
  methods:{
   
  }
}
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.2.2/lib/theme-chalk/index.css");
.bg {
  background: url('../assets/imgs/back.jpg') no-repeat;
  background-size: 100%;
  width: 100%;
  height: 600px;
  display: flex;
  align-items: flex-end;
  justify-content: center;
  overflow: visible;
}
.single{
  width: 300px;
  height: 250px;
  background: #fff;
  margin-bottom: -150px;
  border-top: 5px solid #026660;
  margin-right: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
/*  .el-carousel__item{
    border-bottom: 1px #fff solid;
  }*/ 
  .el-carousel__item:nth-child(2n) {
    background-color: #17B794;
    color: #fff;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #17B794;
    color: #fff;
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
.singleCarousel .desc{
  font-size: 28px;
  width: 100%;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  margin-top: 35px;
}
.singleCarousel .btn{
  margin-top: 100px;
  padding: 6px 30px 6px 30px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  border: 1px #fff solid;
  font-size: 30px;
  border-radius: 5px;
}
.singleCarousel .btn:hover{
  color: #000;
  background: #fff;
}
</style>

