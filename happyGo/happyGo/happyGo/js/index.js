var item = document.querySelector('.viewArea .item'); //��Ҫ��Ⱦ�ĵ����б�Ԫ��
//��Ҫ��Ⱦ�ĵ����б�Ԫ��
var container = document.querySelector('.container'); //��������Ԫ��


var start = 0; // ��ʼλ��
var pageSize = 10; // ÿҳչʾ������
var total = 100000; //�����ܳ���

// var itemHeight = 61; // ÿ��item�ĸ߶�
var itemStyle = getComputedStyle(item); // ��ȡԪ��������ʽ
var itemHeight = Number(itemStyle.height.split('px')[0]) + Number(itemStyle.borderTopWidth.split('px')[0]) + Number(itemStyle.borderBottomWidth.split('px')[0]); // ÿ��item�ĸ߶�
console.log('itemHeight', itemHeight);
// ���������б����ܸ߶�
// document.querySelector('.container-article .content').style.height = itemHeight * total + 'px';
updateDom(start, pageSize, itemHeight, 0);



//������Ⱦ�б�����
function updateDom(start, pageSize, itemHeight, height) {
    $.ajax({
            url: "http://39.103.227.108:49154/article/list",
            type: "GET",
            dataType: "JSON",
            success(res) {
                const itemList = new Array();
                var items = document.querySelectorAll('.viewArea .item');
                document.querySelector('.container-article .content .viewArea').style.transform = 'translateY(' + height + 'px)';
                let allHeadline = document.querySelectorAll('.viewArea .headline'); // ��ȡ������Ⱦ�б�
                let allSynopsis = document.querySelectorAll('.viewArea .synopsis'); // ��ȡ������Ⱦ�б�
                for (var i = start, itemIndex = 0, len = start + pageSize; i < len; i++, itemIndex++) {
                    // var index = i % pageSize; // ����������б����±�
                    if (i < res.data.length) {
                        allHeadline[itemIndex].innerHTML = res.data[i].title;
                        allSynopsis[itemIndex].innerHTML = res.data[i].summary;
                        itemList.push(items[i]);
                    } else {
                        allHeadline[itemIndex].innerHTML = '';
                        allSynopsis[itemIndex].innerHTML = '';
                    }

                }
                console.log(itemList[0])
                for (let i = 0; i < itemList.length; i++) {
                    itemList[i].onclick = function() {
                        console.log('222')
                        console.log(this)
                    }
                }
            },
        })
        // console.log(res)

}
// ������������

function handleScroller() {

    var lastStart = 0; // �ϴο�ʼ��λ��
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


// �����ͽ���
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