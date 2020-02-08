$.extend($.fn.validatebox.defaults.rules, {
    //midLength 自定义的名称，
    midLength: {
        //value：表示input输入框中的值，param：接收的是validType="midLength[2,5]"中的参数[2,5]
        validator: function (value, param) {
            //param[0]表示数组中的第一个参数，如[2,5]中的2
            return value.length >= param[0] && value.length <= param[1];
        },
        //验证失败时的提示信息
        // message: '用户名必须在2~5个字符之间'
        message: ''
    },
    //密码验证
    // validType="equalLength[4]"
    equalLength: {
        validator: function (value, param) {
            //param[0]表示数组中的第一个参数，如[2,5]中的2
            return value.length == param[0];
        },
        //验证失败时的提示信息
        message: "密码必须是4个字符"
    }
});

// editor 编辑类型中没有datetimebox，需要自己扩展，根据官方api扩展的
$.extend($.fn.datagrid.defaults.editors, {
    datetimebox: {
        init: function (container, options) {
            var box = $('<input/>').appendTo(container);
            //1.初始化datetimebox
            box.datetimebox(options);
            return box;
        },
        getValue: function (target) {
            return $(target).datetimebox('getValue');
        },
        setValue: function (target, value) {
            $(target).datetimebox('setValue', value);
        },
        resize: function (target, width) {
            var box = $(target);
            box.datetimebox('resize', width);
        },
        destroy: function (target) {
            $(target).datetimebox('destroy');
        }

    }
});