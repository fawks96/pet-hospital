<template>
   <el-container>
    <el-header>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item >病例学习主页</el-breadcrumb-item>
      </el-breadcrumb>
    </el-header>
    <el-container>
    	<el-header>
    		<span class="demonstration">请选择病例种类</span>
				<el-cascader
				expand-trigger="hover"
				:options="options"
				v-model="selectedOptions2"
				@change="handleChange">
				</el-cascader>
    	</el-header>
    	<el-main>
    		<el-table :data="tableData">
		      <el-table-column
		        prop="case"
		        label="病名"
		        min-width="150">
		      </el-table-column>
		      <el-table-column
		        prop="date"
		        label="日期"
		        min-width="150">
		      </el-table-column>
		      <el-table-column
		        prop="pet"
		        label="宠物名"
		        min-width="180">
		      </el-table-column>
		      <el-table-column
		        prop="old"
		        label="年龄"
		        min-width="120">
		      </el-table-column>
		      <el-table-column
		        prop="desc"
		        label="描述"
		        min-width="180">
		      </el-table-column>
		      <el-table-column
		        prop="status"
		        label="治疗状态"
		        min-width="180">
		      </el-table-column>
		      <el-table-column
			      label="操作"
			      min-width="100">
			      <template slot-scope="scope">
			        <el-button  type="primary" size="small" @click="detail">查看</el-button>
			      </template>
			    </el-table-column>
		    </el-table>

        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="page.page"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="page.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="page.total">
        </el-pagination>
    	</el-main>
    </el-container>
  </el-container>
</template>
<script>
export default{
  name:'learn',
  data(){
    return{
      options: [
      ],
      page: {
        page: 1,
        size: 5,
        total: 0
      },
      selectedOptions: [],
      selectedOptions2: [],
      tableData: [
      	{
      		case: '狂犬病',
          date: '2016-05-02',
          pet: '(撕家)阿拉斯加',
          old: '3岁',
          desc: '误食锦华的袜子，抽搐，伴随躁动',
          status: '治疗康复'
        }, 
        {
      		case: '狂犬病',
          date: '2016-05-02',
          pet: '(酒鬼)阿拉斯加',
          old: '3岁',
          desc: '误食锦华的袜子，抽搐，伴随躁动',
          status: '治疗康复'
        },
        {
      		case: '狂犬病',
          date: '2016-05-02',
          pet: '(墨爷)阿拉斯加',
          old: '3岁',
          desc: '误食锦华的袜子，抽搐，伴随躁动',
          status: '治疗康复'
        }
      ]
    }
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  	handleChange () {

  	},
  	detail () {
  		this.$router.push({name: 'case', params: { case: 1}})
  	}
  }
}
</script>
<style scoped>
.el-pagination{
  padding: 12px 0;
  display: flex;
  justify-content: flex-end;
}
</style>