
<template>
  <el-container>
  	<el-header>
  		<el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/learn' }">病例学习主页</el-breadcrumb-item>
        <el-breadcrumb-item>病例xxx</el-breadcrumb-item>
      </el-breadcrumb>
  	</el-header>
  	<el-container>

  	</el-container>
  </el-container>
</template>
<script>
export default{
  name: 'case',
  data () {
    return{

    }
  },
  created() {

  },
  methods: {

  }
}
</script>
<style scoped>
.zujian {
	width: 50%;
	height: 500px;
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}
.btn{
	align-self: flex-end;
	margin-top: 30px;
}
</style>