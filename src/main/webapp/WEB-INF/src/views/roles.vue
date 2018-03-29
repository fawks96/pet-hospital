
<template>
  <el-container>
    <el-header>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/play' }">角色扮演主页</el-breadcrumb-item>
        <el-breadcrumb-item>特定角色扮演</el-breadcrumb-item>
      </el-breadcrumb>
    </el-header>
    <el-container class="process">
      <div class="singleProcess" v-for="(item, index) in arr">
        <el-steps :active="item.active" finish-status="success">
          <el-step title="步骤 1" description="这是一段很长很长很长的描述性文字"></el-step>
          <el-step title="步骤 2" description="这是一段很长很长很长的描述性文字"></el-step>
          <el-step title="步骤 3" description="这是一段很长很长很长的描述性文字"></el-step>
        </el-steps>

        <el-button type="success" @click="next(index)">下一步</el-button>
      </div>

    </el-container>
  </el-container>
</template>
<script>
import echarts from 'echarts'
export default{
  name:'show',
  data(){
    return {
      msg: '',
      active: 0,
      arr: [
        {
          active:0
        },
        {
          active:0
        }
      ]
    }
  },
  created() {
    this.msg = '这里是' + this.$route.params.role + '扮演页'
  },
  mounted () {
    
  },
  methods: {
    next(index) {
      if (this.arr[index].active++ > 2) this.arr[index].active = 0;
    }
  }
}
</script>
<style scoped>
.moxing {
  width: 760px;
  height: 580px;
}
.process{
  display: flex;
  flex-direction: column;
  align-items: center;
}
.singleProcess{
  width: 90%;
  padding: 20px 15px 20px 15px;
}
</style>