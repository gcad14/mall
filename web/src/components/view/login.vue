<template>
  <div>
    <el-button round @click="dialogFormVisible = true">新增</el-button>

    <el-dialog title="新增" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addUser">确 定</el-button>
      </div>
    </el-dialog>


    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        prop="userName"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="性别"
        width="120">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名字"
        width="120">
      </el-table-column>
      <el-table-column
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>


    <div class="block" align="right">
<!--      <span class="demonstration">完整功能</span>-->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage4"
        :page-sizes="[5, 10, 30, 50]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>

export default {
  name: "login",
  data() {
    return {
      tableData: [],
      dialogFormVisible: false,
      form: {
        name: ''
      },
      formLabelWidth: '120px',
      currentPage4: 0,
      pageNum:1,
      pageSize:5,
      total:0,
    }
  },
  mounted() {
    this.queryList();
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.queryList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNum = val;
      this.queryList();
    },
    queryList(){
      this.axios.get("http://localhost:8001/user/getUserList?pageNum="+this.pageNum+"&pageSize="+this.pageSize)
        .then(res=>{
          console.log(res.data.data);
          this.tableData = res.data.data.list;
          this.total = res.data.data.total;
          this.pageSize = res.data.data.pageSize;
            this.pageNum = res.data.data.pageNum;
          this.$message.success("查询成功");
        }).catch(res=>{
          this.$message.error("查询异常");
      })
    },
    addUser: function () {
      this.axios.post("http://localhost:8001/user/addUser", this.form)
        .then(res => {
          this.$message.success("成功");
          this.dialogFormVisible = false;
          this.clear();
        }).catch(error => {
        this.$message.success("失败");
      })
    },
    clear:function (){
      this.form = {
        name: ''
      };
    }
  }

}
</script>

<style scoped>

</style>
