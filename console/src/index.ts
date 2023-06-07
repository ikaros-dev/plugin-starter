import { definePlugin } from "@runikaros/shared"
import HomeView from './views/HomeView.vue';
import { Files as FilesIcon } from '@element-plus/icons-vue';
import {  markRaw } from "vue"

// console.log('Hello Ikaros')
export default definePlugin({
    name: 'PluginStarter',
    components: {},
    routes: [
      {
        path: '/plugin-home-view',
        component: HomeView,
        name: "HomeView",
        meta: {
          name: 'core.sidebar.menu.items.files',
            group: 'content',
            icon: markRaw(FilesIcon),
            priority: 0,
        }
      }
    ],
})