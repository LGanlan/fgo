layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Grade = {
        tableId: "gradeTable"
    };

    /**
     * 初始化表格的列
     */
    Grade.initColumn = function () {
        return [[
            {field: 'id', hide: true, title: '主键id'},
            {field: 'grade', title: '评分'},
            {field: 'sort', title: '排序'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Grade.search = function () {
        var queryData = {};


        table.reload(Grade.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    Grade.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/grade/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    Grade.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/grade/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    Grade.exportExcel = function () {
        var checkRows = table.checkStatus(Grade.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Grade.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/grade/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Grade.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Grade.tableId,
        url: Feng.ctxPath + '/grade/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Grade.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Grade.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    Grade.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        Grade.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Grade.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Grade.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            Grade.onDeleteItem(data);
        }
    });
});
