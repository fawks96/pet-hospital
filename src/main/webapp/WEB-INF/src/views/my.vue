
<template>
  <el-container>
  	<el-header>
  		<el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>我的</el-breadcrumb-item>
      </el-breadcrumb>
  	</el-header>
  	<el-container>
  		<el-aside>
  			<img :src="imageUrl" class="imgs">
  		</el-aside>
  	</el-container>
  </el-container>
</template>
<script>
export default{
  name:'login',
  data(){
    return{
    }
  },
  computed: {
  	imageUrl () {
  		if (this.$store.state.user.picture_url) {
  			return 'http://ecnupet.cn:8080/pet/' + this.$store.state.user.picture_url
  		}
  		else
  			return ''
  	}
  },
  created () {
  	console.log(this.$store.state.user)
  },
  methods: {
  	
  }
}
</script>
<style scoped>
.login-bottom {
	width: 100%;
	margin-top: 30px;
	display: flex;
	flex-direction: row-reverse;
}
.imgs {
	width: 150px;
	height: auto;

}
</style>