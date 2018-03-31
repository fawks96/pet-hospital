<!--App.vue是项目入口文件。-->
<template>
    <div id="app" class="bg">
      <el-container style="height: 100%">
        <el-header class="topbar">
          <el-row :gutter="20" justify="space-between" type="flex">
            <el-col :span="6">
              <div class="grid-content name">
                宠物医院学习系统
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content">
                <el-menu  class="el-menu-demo" mode="horizontal" @select="handleSelect" text-color="#000" background-color="#F1F0EE"
  active-text-color="#026660">
                  <el-menu-item class="subitem" index="1">主页</el-menu-item>
                  <el-menu-item class="subitem" index="2">导览</el-menu-item>
                  <el-submenu  index="3" class="subitem">
                    <template slot="title">学习</template>
                    <el-menu-item index="3-1">角色扮演</el-menu-item>
                    <el-menu-item index="3-2">病例学习</el-menu-item>
                  </el-submenu>
                  <el-menu-item class="subitem" index="4">测试</el-menu-item>
                  <el-menu-item class="subitem" index="5">{{user}}</el-menu-item>
                </el-menu>
              </div>
            </el-col>
          </el-row>
        </el-header>
        <el-main>
          <div style="padding-top: 10px;">
            <router-view></router-view>
          </div>
        </el-main>
      </el-container>  
    </div>
</template>

<script>

export default {
  name: 'app',
  data () {
    return {

    }
  },
  computed: {
    user () {
      return this.$store.state.user.name ? `${this.$store.state.user.name}` : '登陆'
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      switch(key){
        case '1':
          this.$router.push('/')
          break
        case '2':
          this.$router.push('/show')
          break
        case '3-1':
          if (!this.$store.state.user.name) {
            this.$alert('只有登录用户才可以体验角色扮演哦！', '提示', {
              confirmButtonText: '去登陆',
              callback: action => {
                this.$router.push('/login')
              }
            });
          }
          else {
            this.$router.push('/play')
          }
          break
        case '3-2':
          if (!this.$store.state.user.name) {
            this.$alert('只有登录用户才可以学习病例哦！', '提示', {
              confirmButtonText: '去登陆',
              callback: action => {
                this.$router.push('/login')
              }
            });
          }
          else {
            this.$router.push('/learn')
          }
          break
        case '4':
          if (!this.$store.state.user.name) {
            this.$alert('只有登录用户才可以进行测试哦！', '提示', {
              confirmButtonText: '去登陆',
              callback: action => {
                this.$router.push('/login')
              }
            });
          }
          else {
            this.$router.push('/test')
          }
          break
        case '5':
          if (!this.$store.state.user.name) {
            this.$router.push('/login')
          }
          else {
            this.$router.push('/my')
          }
          break
        default:
          this.$router.push('/show')
      }
    }
  }
}
</script>

<style scoped>
@import url("//unpkg.com/element-ui@2.2.2/lib/theme-chalk/index.css");
.bg {
  margin: 0;
  height: 100%;
}
.name {
  font-size: 35px;
  height: 60px;
  line-height: 60px;
  font-family: "PingFang SC";
  color: #026660;
}
.el-submenu{
  list-style: none;
  padding: 0;
  height: auto;
  line-height: auto;

}
.el-menu--horizontal{
  border-bottom: none;
}
.grid-content{
  display: flex;
  flex-direction: row-reverse;
}
</style>
