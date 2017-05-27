(function ($) {
    var oldHTML = $.fn.html;
    $.fn.formHtml = function () {
        if (arguments.length) return oldHTML.apply(this, arguments);
        $("input,textarea,button", this).each(function () {
            this.setAttribute('value', this.value);
        });
        $(":radio,:checkbox", this).each(function () {
            if (this.checked) this.setAttribute('checked', 'checked');
            else this.removeAttribute('checked');
        });
        $("option", this).each(function () {
            if (this.selected) this.setAttribute('selected', 'selected');
            else this.removeAttribute('selected');
        });
        return oldHTML.apply(this);
    };
    $.fn.formDisabled = function (param) {
        $("input,textarea,button,:radio,:checkbox,select", this).each(function () {
            this.setAttribute('disabled',param);
        });
        return oldHTML.apply(this);
    };
})(jQuery);