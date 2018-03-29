
<template>
  <el-container>
  	<el-header>
  		<el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>测试</el-breadcrumb-item>
      </el-breadcrumb>
  	</el-header>
  	<el-container>
  		<el-aside>
  			<el-menu
		      default-active="1"
		      class="el-menu-vertical-demo"
		      @select="handleOpen"
		      @close="handleClose"
		      background-color="#fff">
		    	<el-menu-item index="1">
		        <i class="el-icon-menu"></i>
		        <span slot="title">测试</span>
		      </el-menu-item>
		      <el-menu-item index="2">
		        <i class="el-icon-menu"></i>
		        <span slot="title">答题记录</span>
		      </el-menu-item>
		    </el-menu>
  		</el-aside>
  		<el-main style="padding-top: 0">
  			<div class="zujian" v-if="prepare && showTest">
	  			<el-transfer
				    v-model="chosenCat"
				    filterable
				    :titles="['题目分类', '目标考卷']"
				    :button-texts="['到左边', '到右边']"
				    :format="{
				      noChecked: '${total}',
				      hasChecked: '${checked}/${total}'
				    }"
				    @change="handleChange"
				    :data="data">
				  </el-transfer>
				  <el-button type="primary" class="btn" @click="goTest">去考试</el-button>
				</div>

				<div v-if="!prepare && showTest">
					<el-card class="box-card">
					  <div slot="header" class="clearfix">
					    <span>试卷</span>
					    <el-button style="float: right; padding: 3px 0" type="text" @click="reprepare">重新组卷</el-button>
					  </div>
					  <div v-for="o in 4" :key="o" class="text item">
					    {{'考试题 ' + o }}
					  </div>
					</el-card>
				</div>

				<div v-if="!showTest">
					<el-card class="box-card">
					  <div slot="header" class="clearfix">
					    <span>历史答题记录</span>
					  </div>
					  <div v-for="o in 4" :key="o" class="text item">
					    {{'考试题 ' + o }}
					  </div>
					</el-card>
				</div>
  		</el-main>
  	</el-container>
  </el-container>
</template>
<script>
export default{
  name: 'test',
  data () {
  	const generateData = _ => {
      const data = [];
      for (let i = 1; i <= 15; i++) {
        data.push({
          key: i,
          label: `${ i }号疾病`
        });
      }
      return data;
    };
    return{
      data: generateData(),
      chosenCat: [],
      prepare: true,
      questions: [],
      key: '1'
    }
  },
  computed: {
		showTest () {
			return this.key == '1' ? true : false
		}
  },
  created() {
  	
  },
  methods: {
  	handleOpen(key, keyPath) {
  		console.log(key)
      this.key = key
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleChange () {

    },
    goTest () {
    	if (this.chosenCat.length == 0) {
    		this.$notify({
          title: '提示',
          message: '请先选择考试题的种类哦！'
        });
        return false
    	}
    	console.log(this.chosenCat)
  		this.prepare = false
    },
    reprepare () {
    	this.prepare = true
    	this.questions = []
    }
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