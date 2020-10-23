layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Servant = {
        tableId: "servantTable"
    };

    /**
     * 初始化表格的列
     */
    Servant.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'name', sort: true, title: '姓名'},
            {field: 'classId', sort: true, title: '职阶id'},
            {field: 'gradeId', sort: true, title: '评分id'},
            {field: 'isHas', sort: true, title: '是否拥有（0 无 1 有）'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Servant.search = function () {
        var queryData = {};


        table.reload(Servant.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    Servant.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/servant/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    Servant.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/servant/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    Servant.exportExcel = function () {
        var checkRows = table.checkStatus(Servant.tableId);
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
    Servant.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/servant/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Servant.tableId);
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
        elem: '#' + Servant.tableId,
        url: Feng.ctxPath + '/servant/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Servant.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Servant.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    Servant.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        Servant.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Servant.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Servant.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            Servant.onDeleteItem(data);
        }
    });
});
