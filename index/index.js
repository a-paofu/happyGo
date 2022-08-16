var item = document.querySelector('.viewArea .item'); //需要渲染的单个列表元素
var container = document.querySelector('.container'); //可视区域元素


var start = 0; // 开始位置
var pageSize = 10; // 每页展示的数据
var total = 100000; //数据总长度

// var itemHeight = 61; // 每个item的高度
var itemStyle = getComputedStyle(item); // 获取元素最终样式
var itemHeight = Number(itemStyle.height.split('px')[0]) + Number(itemStyle.borderTopWidth.split('px')[0]) + Number(itemStyle.borderBottomWidth.split('px')[0]); // 每个item的高度
console.log('itemHeight', itemHeight);
// 设置数据列表的总高度
// document.querySelector('.container-article .content').style.height = itemHeight * total + 'px';
updateDom(start, pageSize, itemHeight, 0);



//更新渲染列表函数
function updateDom(start, pageSize, itemHeight, height) {
    $.ajax({
            url: "http://39.103.227.108:49154/article/list",
            type: "GET",
            dataType: "JSON",
            success(res) {
                // console.log(res.data.length)
                document.querySelector('.container-article .content .viewArea').style.transform = 'translateY(' + height + 'px)';
                let allHeadline = document.querySelectorAll('.viewArea .headline'); // 获取所有渲染列表
                let allSynopsis = document.querySelectorAll('.viewArea .synopsis'); // 获取所有渲染列表
                for (var i = start, itemIndex = 0, len = start + pageSize; i < len; i++, itemIndex++) {
                    // var index = i % pageSize; // 计算出数据列表的下标
                    if (i < res.data.length) {
                        allHeadline[itemIndex].innerHTML = res.data[i].title;
                        allSynopsis[itemIndex].innerHTML = res.data[i].summary;
                    } else {
                        allHeadline[itemIndex].innerHTML = '';
                        allSynopsis[itemIndex].innerHTML = '';
                    }

                }
                // console.log(itemIndex)

            },
        })
        // console.log(res)

}
// 滚动处理函数

function handleScroller() {

    var lastStart = 0; // 上次开始的位置
    return () => {

        console.log
        var currentScrollTop = container.scrollTop;
        var fixedScrollTop = currentScrollTop - currentScrollTop % itemHeight;
        var start = Math.floor(currentScrollTop / itemHeight);

        if (lastStart !== start) {
            lastStart = start;
            updateDom(start, pageSize, itemHeight, fixedScrollTop);
        }
    }
}


// 防抖和节流
function throttle(fn, delay, atleast) {
    let timer = null;
    let rAFtimer = null;
    let previous = 0;

    return function() {
        let now = Date.now();
        if (now - previous > atleast) {
            // console.log('now - previous > atleast');
            fn();
            previous = now;
        } else {
            if (delay > 20) {
                // console.log('delay > 20');
                clearTimeout(timer);
                timer = setTimeout(function() {
                    fn();
                    previous = 0;
                }, delay);
            } else {

                cancelAnimationFrame(rAFtimer);
                rAFtimer = requestAnimationFrame(function() {
                    requestIdleCallback(fn);
                });
            }
        }
    }
}
document.querySelector('.container').addEventListener('scroll', throttle(handleScroller(), 16, 500), false);
// document.querySelector('.container').addEventListener('scroll', handleScroller(), false);


var container = document.querySelector('.container')
var headerNav = document.querySelector('.header-nav')
var navFirst = document.querySelector('.container-nav')
var navSecond = document.querySelector('.nav-second')
var main = document.querySelector('main')


// if (headerNav.className == 'header-nav') {

//     headerNav.className = 'nav'
//     navFirst.style.display = 'none'

// }





container.addEventListener('scroll', function() {


    if (container.scrollTop == '0') {
        navFirst.style.display = 'block'
        headerNav.className = 'header-nav nav'
    }
    if (container.scrollTop >= '1000') {
        navFirst.style.display = 'none'

    } else {

    }

})