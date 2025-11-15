import { 
  LayoutDashboard, 
  Moon, 
  AlarmClock, 
  Music, 
  ListChecks, 
  Activity, 
  Target, 
  Gift, 
  ClipboardCheck,
  Settings,
  Users,
  Bell
} from "lucide-react";
import { NavLink } from "@/components/NavLink";
import { useLocation } from "react-router-dom";

import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarHeader,
  useSidebar,
} from "@/components/ui/sidebar";

const mainItems = [
  { title: "Dashboard", url: "/", icon: LayoutDashboard },
  { title: "Registro de Sueño", url: "/suenio", icon: Moon },
  { title: "Alarmas", url: "/alarmas", icon: AlarmClock },
  { title: "Música", url: "/musica", icon: Music },
  { title: "Hábitos", url: "/habitos", icon: ListChecks },
  { title: "Actividades", url: "/actividades", icon: Activity },
  { title: "Objetivos", url: "/objetivos", icon: Target },
  { title: "Recompensas", url: "/recompensas", icon: Gift },
  { title: "Evaluación Diaria", url: "/evaluacion", icon: ClipboardCheck },
];

const adminItems = [
  { title: "Panel Admin", url: "/admin", icon: Settings },
  { title: "Usuarios", url: "/admin/users", icon: Users },
  { title: "Recompensas", url: "/admin/recompensas", icon: Gift },
  { title: "Tipos Música", url: "/admin/tipos-musica", icon: Music },
  { title: "Música", url: "/admin/musica", icon: Music },
  { title: "Notificaciones", url: "/admin/notificaciones", icon: Bell },
];

export function AppSidebar() {
  const { state } = useSidebar();
  const location = useLocation();
  const currentPath = location.pathname;
  const collapsed = state === "collapsed";

  const isActive = (path: string) => {
    if (path === "/") return currentPath === "/";
    return currentPath.startsWith(path);
  };

  return (
    <Sidebar collapsible="icon" className="border-r border-sidebar-border">
      <SidebarHeader className="border-b border-sidebar-border p-4">
        <div className="flex items-center gap-2">
          <div className="flex h-8 w-8 items-center justify-center rounded-lg bg-primary">
            <Moon className="h-5 w-5 text-primary-foreground" />
          </div>
          {!collapsed && (
            <div>
              <h2 className="text-lg font-bold text-sidebar-foreground">NightWave</h2>
              <p className="text-xs text-muted-foreground">Gestión del sueño y bienestar</p>
            </div>
          )}
        </div>
      </SidebarHeader>

      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupLabel>Principal</SidebarGroupLabel>
          <SidebarGroupContent>
            <SidebarMenu>
              {mainItems.map((item) => (
                <SidebarMenuItem key={item.title}>
                  <SidebarMenuButton asChild isActive={isActive(item.url)}>
                    <NavLink to={item.url} className="flex items-center gap-2">
                      <item.icon className="h-4 w-4" />
                      <span>{item.title}</span>
                    </NavLink>
                  </SidebarMenuButton>
                </SidebarMenuItem>
              ))}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>

        <SidebarGroup>
          <SidebarGroupLabel>Administración</SidebarGroupLabel>
          <SidebarGroupContent>
            <SidebarMenu>
              {adminItems.map((item) => (
                <SidebarMenuItem key={item.title}>
                  <SidebarMenuButton asChild isActive={isActive(item.url)}>
                    <NavLink to={item.url} className="flex items-center gap-2">
                      <item.icon className="h-4 w-4" />
                      <span>{item.title}</span>
                    </NavLink>
                  </SidebarMenuButton>
                </SidebarMenuItem>
              ))}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
}
