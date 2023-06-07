import { definePlugin } from "@runikaros/shared"
import HomeView from "./views/HomeView.vue";

// console.log('Hello Ikaros')
export default definePlugin({
    name: 'PluginStater',
    components: {},
    routes: [
      {
        parentName: "Root",
        route: {
          path: "/example",
          children: [
            {
              path: "",
              name: "Example",
              component: HomeView,
              meta: {
                title: "示例页面",
                searchable: true,
                menu: {
                  name: "示例页面",
                  group: "示例分组",
                  priority: 0,
                },
              },
            },
          ],
        },
      },
    ],
})