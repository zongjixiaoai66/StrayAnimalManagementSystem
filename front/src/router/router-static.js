import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import chongwu from '@/views/modules/chongwu/list'
    import chongwuCollection from '@/views/modules/chongwuCollection/list'
    import chongwuLiuyan from '@/views/modules/chongwuLiuyan/list'
    import chongwujiyang from '@/views/modules/chongwujiyang/list'
    import chongwulingyang from '@/views/modules/chongwulingyang/list'
    import chongwulingyangshenhe from '@/views/modules/chongwulingyangshenhe/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import ziyuanzhe from '@/views/modules/ziyuanzhe/list'
    import config from '@/views/modules/config/list'
    import dictionaryChongwu from '@/views/modules/dictionaryChongwu/list'
    import dictionaryChongwuCollection from '@/views/modules/dictionaryChongwuCollection/list'
    import dictionaryChongwujiyangYesno from '@/views/modules/dictionaryChongwujiyangYesno/list'
    import dictionaryChongwulingyangshenheYesno from '@/views/modules/dictionaryChongwulingyangshenheYesno/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryJieshu from '@/views/modules/dictionaryJieshu/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryChongwu',
        name: '宠物类型',
        component: dictionaryChongwu
    }
    ,{
        path: '/dictionaryChongwuCollection',
        name: '收藏表类型',
        component: dictionaryChongwuCollection
    }
    ,{
        path: '/dictionaryChongwujiyangYesno',
        name: '审核状态',
        component: dictionaryChongwujiyangYesno
    }
    ,{
        path: '/dictionaryChongwulingyangshenheYesno',
        name: '审核状态',
        component: dictionaryChongwulingyangshenheYesno
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryJieshu',
        name: '是否被认领',
        component: dictionaryJieshu
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/chongwu',
        name: '宠物信息',
        component: chongwu
      }
    ,{
        path: '/chongwuCollection',
        name: '宠物收藏',
        component: chongwuCollection
      }
    ,{
        path: '/chongwuLiuyan',
        name: '宠物留言',
        component: chongwuLiuyan
      }
    ,{
        path: '/chongwujiyang',
        name: '宠物寄养',
        component: chongwujiyang
      }
    ,{
        path: '/chongwulingyang',
        name: '宠物领养',
        component: chongwulingyang
      }
    ,{
        path: '/chongwulingyangshenhe',
        name: '宠物领养审核',
        component: chongwulingyangshenhe
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/ziyuanzhe',
        name: '自愿者',
        component: ziyuanzhe
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
