
<template>
  <el-container>
  	<el-header>
  		<el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>登陆</el-breadcrumb-item>
      </el-breadcrumb>
  	</el-header>
  	<el-container>
  		<el-aside width="70%">
        <img src="../assets/imgs/time.jpg" style="width: 100%; height: auto;">
      </el-aside>
      <el-main style="padding-top: 0">
        <el-card class="box-card" v-if="register" v-loading="loading1"
			    element-loading-text="正在登陆中"
			    element-loading-spinner="el-icon-loading"
			    @keyup.enter.native="login">
				  <div slot="header" class="clearfix">
				    <span>登陆</span>
				    <el-button style="float: right; padding: 3px 0" type="text" @click="goRegister">还没账号,去注册</el-button>
				  </div>
				  <div>
				  	<div class="demo-input-suffix" style="display: flex;">
						  <span style="min-width: 60px;line-height: 40px">账号:</span>
						  <el-input
						    placeholder="请输入账号"
						    v-model="account">
						  </el-input>
						</div>
						<div class="demo-input-suffix" style="display: flex;margin-top: 20px">
						  <span style="min-width: 60px;line-height: 40px">密码:</span>
						  <el-input
						    placeholder="请输入密码"
						    type="password"
						    v-model="password"
						    >
						  </el-input>
						</div>
						<div class="login-bottom">
							<el-button type="primary" @click="login">登陆</el-button>

						</div>
				  </div>
				</el-card>

				<el-card class="box-card" v-if="!register" v-loading="loading1"
			    element-loading-text="正在注册中"
			    element-loading-spinner="el-icon-loading">
				  <div slot="header" class="clearfix">
				    <span>注册</span>
				    <el-button style="float: right; padding: 3px 0" type="text" @click="goLogin">已有账号,去登陆</el-button>
				  </div>
				  <div>
				  	<div style="margin-bottom: 15px;">
				  		<span>上传头像</span>
				  		<el-upload
							  class="avatar-uploader"
							  action="http://ecnupet.cn:8080/pet/file"
							  :show-file-list="false"
							  :on-success="handleAvatarSuccess"
							  :before-upload="beforeAvatarUpload">
							  <img v-if="imageUrl" :src="imageUrl" class="avatar">
							  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
							</el-upload>
				  	</div>
				  	<div class="demo-input-suffix" style="display: flex;">
						  <span style="min-width: 60px;line-height: 40px">账号:</span>
						  <el-input
						    placeholder="请输入账号"
						    v-model="account1">
						  </el-input>
						</div>
						<div class="demo-input-suffix" style="display: flex;margin-top: 20px">
						  <span style="min-width: 60px;line-height: 40px">密码:</span>
						  <el-input
						    placeholder="请输入密码"
						    type="password"
						    v-model="password1">
						  </el-input>
						</div>

						<div class="demo-input-suffix" style="display: flex;margin-top: 20px">
						  <span style="min-width: 90px;line-height: 40px">确认密码:</span>
						  <el-input
						    placeholder="请输入密码"
						    type="password"
						    v-model="repassword">
						  </el-input>
						</div>
						<div class="login-bottom">
							<el-button type="primary" @click="regis">注册</el-button>

						</div>
				  </div>
				</el-card>
      </el-main>
  	</el-container>
  </el-container>
</template>
<script>
export default{
  name:'login',
  data(){
    return{
    	register: true,
    	account: '',
    	password: '',
    	account1: '',
    	password1: '',
    	repassword: '',
    	loading1: false,
    	image: ''
    }
  },
  computed: {
  	imageUrl () {
  		if (this.image)
  			return  'http://ecnupet.cn:8080/pet/' + this.image
  		else
  			return ''
  	}
  },
  created () {
  	console.log(this.$store.state.user.picture_url)
  },
  methods: {
  	goRegister () {
  		this.register = false
  	},
  	goLogin () {
  		this.register = true
  	},
  	regis () {
  		let vm = this
  		if (!vm.account1 || !vm.password1) {
  			vm.$notify({
          title: '提示',
          message: '输入不能为空~'
        });
        return false
  		}
  		vm.loading1 = true
  		this.$http.post('/pet/user/register',{
  			name: vm.account1,
  			pwd: vm.password1,
  			auth: 1,
  			picture_url: vm.image

  		},{
  			'Access-Control-Allow-Origin': '*'
  		})
	    .then(function(res){


	    	vm.loading1 = false
	    	vm.$router.push('/')
	    })
	    .catch(function(err){
	        console.log(err);
	        vm.loading1 = false
	        vm.$notify({
          title: '提示',
          message: '注册失败~'
        });
	    })
  	},
  	login () {
  		let vm = this
  		if (!vm.account || !vm.password) {
  			vm.$notify({
          title: '提示',
          message: '输入不能为空~'
        });
        return false
  		}
  		vm.loading1 = true
  		this.$http.post('/pet/user/login',{
  			username: vm.account,
  			password: vm.password
  		},{
  			'Access-Control-Allow-Origin': '*'
  		})
	    .then(function(res){
	    	vm.$store.commit("login", {name:res.data.user.name,picture_url:res.data.user.picture_url,id:res.data.user.id});

	    	vm.loading1 = false
	    	vm.$router.push('/')
	    })
	    .catch(function(err){
	        console.log(err);
	        vm.loading1 = false
	        vm.$notify({
          title: '提示',
          message: '登录失败~'
        });
	    })
  	},
  	handleAvatarSuccess(res, file) {
      this.image = res.webURL
      console.log(res.webURL)
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 4;
      const isJPG = (file.type === 'image/jpeg') || (file.type === 'image/png') || (file.type === 'image/jpg') || (file.type === 'image/bmp') ||  (file.type === 'image/gif');
      if (!isJPG) {
        this.$message.error('请上传图片！');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 4MB!');
      }
      return isLt2M;
    }
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
.avatar-uploader {
	display: inline-block;
	margin-left: 20px;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>