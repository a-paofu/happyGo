const id = (location.search).substring(((location.search).lastIndexOf("=") + 1), (location
  .search).length);
$.get(
  'http://39.103.227.108:49154/article/get/'+id,
  id,
  function (data) {
    console.log(data)
    document.querySelector('#root').innerHTML = marked.parse(
      data.data.articleBody.content
    );
    document.querySelector('.article-title').innerHTML = marked.parse(
      data.data.title
    );
    // console.log(marked.parse(
    //   data.data.articleBody.content
    // ));
    // console.log(marked.parse(
    //   data.data.title
    // ));
    // 为文章中的标题标签添加不同的id
    //
    var list = [],
      idList = []
    // #root#root
    $(' h1, h2,h3,h4').each(function (i) {
      $(this).attr('id', i);
      idList.push(i);
      // ' + ($(this).get(0).tagName == 'H1' ? "pl" : "") + '($(this).get(0).tagName == 'H1' ? "pl" : "") ' + + ' 
      list.push('<li class=" "  > <a  href="#' + i + '">' + $(this).text() + '</a> </li>')
    });
    // 添加目录
    $('#catalogs').append(list);
    // 编写监测页面滚动监听事件
    //页面滚动为导航添加样式
    $(window).scroll(function () {
      for (let i = 0; i < idList.length; i++) {
        if ($(window).scrollTop() > $('#' + idList[i]).offset().top - 100 || $(this).scrollTop() + $(this).height() == $(document).height()) {
          $('#catalogs').find('li').eq(i).addClass('active').siblings('li').removeClass('active');
          // $('.j-bj').css('top', i * 44)
        }
      }
    });
    // 编写锚点点击事件
    let $root = $('html, body');
    $('#catalogs li a').on("click", function () {
      $root.animate({
        scrollTop: $($.attr(this, 'href')).offset().top - 65
      }, 400);
      return false
    });
  }

);