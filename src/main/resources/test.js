// Ion.RangeSlider | version 1.9.1 | https://github.com/IonDen/ion.rangeSlider
(function (c, ea, $, M) {
    var aa = 0, s, S = function () {
        var c = M.userAgent, a = /msie\s\d+/i;
        return 0 < c.search(a) && (c = a.exec(c).toString(), c = c.split(" ")[1], 9 > c) ? !0 : !1
    }(), X = "ontouchstart" in $ || 0 < M.msMaxTouchPoints, N = function (c) {
        "Number" !== typeof c && (c = parseFloat(c));
        return isNaN(c) ? null : c
    }, H = {
        init: function (fa) {
            return this.each(function () {
                var a = c.extend({
                    min: null,
                    max: null,
                    from: null,
                    to: null,
                    type: "single",
                    step: null,
                    prefix: "",
                    postfix: "",
                    maxPostfix: "",
                    hasGrid: !1,
                    hideMinMax: !1,
                    hideFromTo: !1,
                    prettify: !0,
                    disable: !1,
                    values: null,
                    onChange: null,
                    onLoad: null,
                    onFinish: null
                }, fa), e = c(this), n = this, I = !1, g = null;
                if (!e.data("isActive")) {
                    e.data("isActive", !0);
                    this.pluginCount = aa += 1;
                    e.prop("value") && (g = e.prop("value").split(";"));
                    "single" === a.type ? g && 1 < g.length ? ("number" !== typeof a.min ? a.min = parseFloat(g[0]) : "number" !== typeof a.from && (a.from = parseFloat(g[0])), "number" !== typeof a.max && (a.max = parseFloat(g[1]))) : g && 1 === g.length && "number" !== typeof a.from && (a.from = parseFloat(g[0])) : "double" === a.type && (g && 1 < g.length ? ("number" !== typeof a.min ?
                        a.min = parseFloat(g[0]) : "number" !== typeof a.from && (a.from = parseFloat(g[0])), "number" !== typeof a.max ? a.max = parseFloat(g[1]) : "number" !== typeof a.to && (a.to = parseFloat(g[1]))) : g && 1 === g.length && ("number" !== typeof a.min ? a.min = parseFloat(g[0]) : "number" !== typeof a.from && (a.from = parseFloat(g[0]))));
                    "number" === typeof e.data("min") && (a.min = parseFloat(e.data("min")));
                    "number" === typeof e.data("max") && (a.max = parseFloat(e.data("max")));
                    "number" === typeof e.data("from") && (a.from = parseFloat(e.data("from")));
                    "number" ===
                    typeof e.data("to") && (a.to = parseFloat(e.data("to")));
                    e.data("step") && (a.step = parseFloat(e.data("step")));
                    e.data("type") && (a.type = e.data("type"));
                    e.data("prefix") && (a.prefix = e.data("prefix"));
                    e.data("postfix") && (a.postfix = e.data("postfix"));
                    e.data("maxpostfix") && (a.maxPostfix = e.data("maxpostfix"));
                    e.data("hasgrid") && (a.hasGrid = e.data("hasgrid"));
                    e.data("hideminmax") && (a.hideMinMax = e.data("hideminmax"));
                    e.data("hidefromto") && (a.hideFromTo = e.data("hidefromto"));
                    e.data("prettify") && (a.prettify = e.data("prettify"));
                    e.data("disable") && (a.disable = e.data("disable"));
                    e.data("values") && (a.values = e.data("values").split(","));
                    a.min = N(a.min);
                    a.min || 0 === a.min || (a.min = 10);
                    a.max = N(a.max);
                    a.max || 0 === a.max || (a.max = 100);
                    "[object Array]" !== Object.prototype.toString.call(a.values) && (a.values = null);
                    a.values && 0 < a.values.length && (a.min = 0, a.max = a.values.length - 1, a.step = 1, I = !0);
                    a.from = N(a.from);
                    a.from || 0 === a.from || (a.from = a.min);
                    a.to = N(a.to);
                    a.to || 0 === a.to || (a.to = a.max);
                    a.step = N(a.step);
                    a.step || (a.step = 1);
                    a.from < a.min && (a.from =
                        a.min);
                    a.from > a.max && (a.from = a.min);
                    a.to < a.min && (a.to = a.max);
                    a.to > a.max && (a.to = a.max);
                    "double" === a.type && (a.from > a.to && (a.from = a.to), a.to < a.from && (a.to = a.from));
                    var z = function (b) {
                        b = b.toString();
                        a.prettify && (b = b.replace(/(\d{1,3}(?=(?:\d\d\d)+(?!\d)))/g, "$1 "));
                        return b
                    }, g = '<span class="irs" id="irs-' + this.pluginCount + '"></span>';
                    e[0].style.display = "none";
                    e.before(g);
                    var p = e.prev(), J = c(ea.body), T = c($), q, C, D, A, B, w, x, m, t, r, H, M, v = !1, y = !1,
                        E = !0, f = {}, U = 0, O = 0, P = 0, l = 0, F = 0, G = 0, V = 0, Q = 0, R = 0, Y = 0, u = 0;
                    parseInt(a.step,
                        10) !== parseFloat(a.step) && (u = a.step.toString().split(".")[1], u = Math.pow(10, u.length));
                    this.updateData = function (b) {
                        E = !0;
                        a = c.extend(a, b);
                        p.find("*").off();
                        T.off("mouseup.irs" + n.pluginCount);
                        J.off("mouseup.irs" + n.pluginCount);
                        J.off("mousemove.irs" + n.pluginCount);
                        p.html("");
                        ba()
                    };
                    this.removeSlider = function () {
                        p.find("*").off();
                        T.off("mouseup.irs" + n.pluginCount);
                        J.off("mouseup.irs" + n.pluginCount);
                        J.off("mousemove.irs" + n.pluginCount);
                        p.html("").remove();
                        e.data("isActive", !1);
                        e.show()
                    };
                    var ba = function () {
                        p.html('<span class="irs"><span class="irs-line"><span class="irs-line-left"></span><span class="irs-line-mid"></span><span class="irs-line-right"></span></span><span class="irs-min">0</span><span class="irs-max">1</span><span class="irs-from">0</span><span class="irs-to">0</span><span class="irs-single">0</span></span><span class="irs-grid"></span>');
                        q = p.find(".irs");
                        C = q.find(".irs-min");
                        D = q.find(".irs-max");
                        A = q.find(".irs-from");
                        B = q.find(".irs-to");
                        w = q.find(".irs-single");
                        M = p.find(".irs-grid");
                        a.hideFromTo && (A[0].style.visibility = "hidden", B[0].style.visibility = "hidden", w[0].style.visibility = "hidden");
                        a.hideFromTo || (A[0].style.visibility = "visible", B[0].style.visibility = "visible", w[0].style.visibility = "visible");
                        a.hideMinMax && (C[0].style.visibility = "hidden", D[0].style.visibility = "hidden", P = O = 0);
                        a.hideMinMax || (C[0].style.visibility = "visible", D[0].style.visibility =
                            "visible", a.values ? (C.html(a.prefix + a.values[0] + a.postfix), D.html(a.prefix + a.values[a.values.length - 1] + a.maxPostfix + a.postfix)) : (C.html(a.prefix + z(a.min) + a.postfix), D.html(a.prefix + z(a.max) + a.maxPostfix + a.postfix)), O = C.outerWidth(), P = D.outerWidth());
                        ga()
                    }, ga = function () {
                        if ("single" === a.type) {
                            if (q.append('<span class="irs-slider single"></span>'), x = q.find(".single"), x.on("mousedown", function (a) {
                                a.preventDefault();
                                a.stopPropagation();
                                K(a, c(this), null);
                                y = v = !0;
                                s = n.pluginCount;
                                S && c("*").prop("unselectable",
                                    !0)
                            }), X) x.on("touchstart", function (a) {
                                a.preventDefault();
                                a.stopPropagation();
                                K(a.originalEvent.touches[0], c(this), null);
                                y = v = !0;
                                s = n.pluginCount
                            })
                        } else "double" === a.type && (q.append('<span class="irs-diapason"></span><span class="irs-slider from"></span><span class="irs-slider to"></span>'), m = q.find(".from"), t = q.find(".to"), H = q.find(".irs-diapason"), L(), m.on("mousedown", function (a) {
                            a.preventDefault();
                            a.stopPropagation();
                            c(this).addClass("last");
                            t.removeClass("last");
                            K(a, c(this), "from");
                            y = v = !0;
                            s = n.pluginCount;
                            S && c("*").prop("unselectable", !0)
                        }), t.on("mousedown", function (a) {
                            a.preventDefault();
                            a.stopPropagation();
                            c(this).addClass("last");
                            m.removeClass("last");
                            K(a, c(this), "to");
                            y = v = !0;
                            s = n.pluginCount;
                            S && c("*").prop("unselectable", !0)
                        }), X && (m.on("touchstart", function (a) {
                            a.preventDefault();
                            a.stopPropagation();
                            c(this).addClass("last");
                            t.removeClass("last");
                            K(a.originalEvent.touches[0], c(this), "from");
                            y = v = !0;
                            s = n.pluginCount
                        }), t.on("touchstart", function (a) {
                            a.preventDefault();
                            a.stopPropagation();
                            c(this).addClass("last");
                            m.removeClass("last");
                            K(a.originalEvent.touches[0], c(this), "to");
                            y = v = !0;
                            s = n.pluginCount
                        })), a.to === a.max && m.addClass("last"));
                        J.on("mouseup.irs" + n.pluginCount, function () {
                            s === n.pluginCount && v && (v = y = !1, r.removeAttr("id"), r = null, "double" === a.type && L(), Z(), S && c("*").prop("unselectable", !1))
                        });
                        J.on("mousemove.irs" + n.pluginCount, function (a) {
                            v && (U = a.pageX, W())
                        });
                        p.on("mousedown", function () {
                            s = n.pluginCount
                        });
                        p.on("mouseup", function (b) {
                            if (s === n.pluginCount && !v && !a.disable) {
                                b = b.pageX;
                                E = !1;
                                b -= p.offset().left;
                                var d = f.fromX + (f.toX - f.fromX) / 2;
                                Q = 0;
                                V = q.width() - G;
                                R = q.width() - G;
                                "single" === a.type ? (r = x, r.attr("id", "irs-active-slider"), W(b)) : "double" === a.type && (r = b <= d ? m : t, r.attr("id", "irs-active-slider"), W(b), L());
                                r.removeAttr("id");
                                r = null
                            }
                        });
                        X && (T.on("touchend", function () {
                            v && (v = y = !1, r.removeAttr("id"), r = null, "double" === a.type && L(), Z())
                        }), T.on("touchmove", function (a) {
                            v && (U = a.originalEvent.touches[0].pageX, W())
                        }));
                        ca();
                        ha();
                        a.hasGrid && ia();
                        a.disable ? (p.addClass("irs-disabled"), p.append('<span class="irs-disable-mask"></span>')) :
                            (p.removeClass("irs-disabled"), p.find(".irs-disable-mask").remove())
                    }, ca = function () {
                        l = q.width();
                        G = x ? x.width() : m.width();
                        F = l - G
                    }, K = function (b, d, h) {
                        ca();
                        E = !1;
                        r = d;
                        r.attr("id", "irs-active-slider");
                        d = r.offset().left;
                        Y = d + (b.pageX - d) - r.position().left;
                        "single" === a.type ? V = q.width() - G : "double" === a.type && ("from" === h ? (Q = 0, R = parseInt(t.css("left"), 10)) : (Q = parseInt(m.css("left"), 10), R = q.width() - G))
                    }, L = function () {
                        var a = m.width(), d = c.data(m[0], "x") || parseInt(m[0].style.left, 10) || m.position().left,
                            h = (c.data(t[0],
                                "x") || parseInt(t[0].style.left, 10) || t.position().left) - d;
                        H[0].style.left = d + a / 2 + "px";
                        H[0].style.width = h + "px"
                    }, W = function (b) {
                        var d = U - Y, d = b ? b : U - Y;
                        "single" === a.type ? (0 > d && (d = 0), d > V && (d = V)) : "double" === a.type && (d < Q && (d = Q), d > R && (d = R), L());
                        c.data(r[0], "x", d);
                        Z();
                        b = Math.round(d);
                        r[0].style.left = b + "px"
                    }, Z = function () {
                        var b = {
                            input: e,
                            slider: p,
                            min: a.min,
                            max: a.max,
                            fromNumber: 0,
                            toNumber: 0,
                            fromPers: 0,
                            toPers: 0,
                            fromX: 0,
                            fromX_pure: 0,
                            toX: 0,
                            toX_pure: 0
                        }, d = a.max - a.min, h;
                        "single" === a.type ? (b.fromX = c.data(x[0], "x") || parseInt(x[0].style.left,
                            10) || x.position().left, b.fromPers = b.fromX / F * 100, h = d / 100 * b.fromPers + a.min, b.fromNumber = Math.round(h / a.step) * a.step, b.fromNumber < a.min && (b.fromNumber = a.min), b.fromNumber > a.max && (b.fromNumber = a.max), u && (b.fromNumber = parseInt(b.fromNumber * u, 10) / u), I && (b.fromValue = a.values[b.fromNumber])) : "double" === a.type && (b.fromX = c.data(m[0], "x") || parseInt(m[0].style.left, 10) || m.position().left, b.fromPers = b.fromX / F * 100, h = d / 100 * b.fromPers + a.min, b.fromNumber = Math.round(h / a.step) * a.step, b.fromNumber < a.min && (b.fromNumber =
                            a.min), b.toX = c.data(t[0], "x") || parseInt(t[0].style.left, 10) || t.position().left, b.toPers = b.toX / F * 100, d = d / 100 * b.toPers + a.min, b.toNumber = Math.round(d / a.step) * a.step, b.toNumber > a.max && (b.toNumber = a.max), u && (b.fromNumber = parseInt(b.fromNumber * u, 10) / u, b.toNumber = parseInt(b.toNumber * u, 10) / u), I && (b.fromValue = a.values[b.fromNumber], b.toValue = a.values[b.toNumber]));
                        f = b;
                        da()
                    }, ha = function () {
                        var b = {
                            input: e,
                            slider: p,
                            min: a.min,
                            max: a.max,
                            fromNumber: a.from,
                            toNumber: a.to,
                            fromPers: 0,
                            toPers: 0,
                            fromX: 0,
                            fromX_pure: 0,
                            toX: 0,
                            toX_pure: 0
                        }, d = a.max - a.min;
                        "single" === a.type ? (b.fromPers = 0 !== d ? (b.fromNumber - a.min) / d * 100 : 0, b.fromX_pure = F / 100 * b.fromPers, b.fromX = Math.round(b.fromX_pure), x[0].style.left = b.fromX + "px", c.data(x[0], "x", b.fromX_pure)) : "double" === a.type && (b.fromPers = 0 !== d ? (b.fromNumber - a.min) / d * 100 : 0, b.fromX_pure = F / 100 * b.fromPers, b.fromX = Math.round(b.fromX_pure), m[0].style.left = b.fromX + "px", c.data(m[0], "x", b.fromX_pure), b.toPers = 0 !== d ? (b.toNumber - a.min) / d * 100 : 1, b.toX_pure = F / 100 * b.toPers, b.toX = Math.round(b.toX_pure), t[0].style.left =
                            b.toX + "px", c.data(t[0], "x", b.toX_pure), L());
                        f = b;
                        da()
                    }, da = function () {
                        var b, d, h, c, g, k;
                        k = G / 2;
                        h = "";
                        "single" === a.type ? (h = f.fromNumber === a.max ? a.maxPostfix : "", A[0].style.display = "none", B[0].style.display = "none", h = I ? a.prefix + a.values[f.fromNumber] + h + a.postfix : a.prefix + z(f.fromNumber) + h + a.postfix, w.html(h), g = w.outerWidth(), k = f.fromX - g / 2 + k, 0 > k && (k = 0), k > l - g && (k = l - g), w[0].style.left = k + "px", a.hideMinMax || a.hideFromTo || (C[0].style.display = k < O ? "none" : "block", D[0].style.display = k + g > l - P ? "none" : "block"), e.attr("value",
                            parseFloat(f.fromNumber))) : "double" === a.type && (h = f.toNumber === a.max ? a.maxPostfix : "", I ? (b = a.prefix + a.values[f.fromNumber] + a.postfix, d = a.prefix + a.values[f.toNumber] + h + a.postfix, h = f.fromNumber !== f.toNumber ? a.prefix + a.values[f.fromNumber] + " \u2014 " + a.prefix + a.values[f.toNumber] + h + a.postfix : a.prefix + a.values[f.fromNumber] + h + a.postfix) : (b = a.prefix + z(f.fromNumber) + a.postfix, d = a.prefix + z(f.toNumber) + h + a.postfix, h = f.fromNumber !== f.toNumber ? a.prefix + z(f.fromNumber) + " \u2014 " + a.prefix + z(f.toNumber) + h + a.postfix :
                            a.prefix + z(f.fromNumber) + h + a.postfix), A.html(b), B.html(d), w.html(h), b = A.outerWidth(), d = f.fromX - b / 2 + k, 0 > d && (d = 0), d > l - b && (d = l - b), A[0].style.left = d + "px", h = B.outerWidth(), c = f.toX - h / 2 + k, 0 > c && (c = 0), c > l - h && (c = l - h), B[0].style.left = c + "px", g = w.outerWidth(), k = f.fromX + (f.toX - f.fromX) / 2 - g / 2 + k, 0 > k && (k = 0), k > l - g && (k = l - g), w[0].style.left = k + "px", d + b < c ? (w[0].style.display = "none", A[0].style.display = "block", B[0].style.display = "block") : (w[0].style.display = "block", A[0].style.display = "none", B[0].style.display = "none"), a.hideMinMax ||
                        a.hideFromTo || (C[0].style.display = k < O || d < O ? "none" : "block", D[0].style.display = k + g > l - P || c + h > l - P ? "none" : "block"), e.attr("value", parseFloat(f.fromNumber) + ";" + parseFloat(f.toNumber)));
                        ja()
                    }, ja = function () {
                        "function" !== typeof a.onFinish || y || E || a.onFinish.call(this, f);
                        "function" !== typeof a.onChange || E || a.onChange.call(this, f);
                        "function" === typeof a.onLoad && !y && E && (a.onLoad.call(this, f), E = !1)
                    }, ia = function () {
                        p.addClass("irs-with-grid");
                        var b, d = "", c = 0, c = 0, e = "";
                        for (b = 0; 20 >= b; b += 1) c = Math.floor(l / 20 * b), c >= l && (c =
                            l - 1), e += '<span class="irs-grid-pol small" style="left: ' + c + 'px;"></span>';
                        for (b = 0; 4 >= b; b += 1) c = Math.floor(l / 4 * b), c >= l && (c = l - 1), e += '<span class="irs-grid-pol" style="left: ' + c + 'px;"></span>', u ? (d = a.min + (a.max - a.min) / 4 * b, d = d / a.step * a.step, d = parseInt(d * u, 10) / u) : (d = Math.round(a.min + (a.max - a.min) / 4 * b), d = Math.round(d / a.step) * a.step, d = z(d)), I && (a.hideMinMax ? (d = Math.round(a.min + (a.max - a.min) / 4 * b), d = Math.round(d / a.step) * a.step, d = 0 === b || 4 === b ? a.values[d] : "") : d = ""), 0 === b ? e += '<span class="irs-grid-text" style="left: ' +
                            c + 'px; text-align: left;">' + d + "</span>" : 4 === b ? (c -= 100, e += '<span class="irs-grid-text" style="left: ' + c + 'px; text-align: right;">' + d + "</span>") : (c -= 50, e += '<span class="irs-grid-text" style="left: ' + c + 'px;">' + d + "</span>");
                        M.html(e)
                    };
                    ba()
                }
            })
        }, update: function (c) {
            return this.each(function () {
                this.updateData(c)
            })
        }, remove: function () {
            return this.each(function () {
                this.removeSlider()
            })
        }
    };
    c.fn.ionRangeSlider = function (s) {
        if (H[s]) return H[s].apply(this, Array.prototype.slice.call(arguments, 1));
        if ("object" !== typeof s &&
            s) c.error("Method " + s + " does not exist for jQuery.ionRangeSlider"); else return H.init.apply(this, arguments)
    }
})(jQuery, document, window, navigator);
