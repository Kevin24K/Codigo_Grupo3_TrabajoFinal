import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Users, Gift, Music, Bell } from "lucide-react";

const stats = [
  { title: "Usuarios Totales", value: "1,234", icon: Users, change: "+12%" },
  { title: "Recompensas Activas", value: "45", icon: Gift, change: "+5" },
  { title: "Pistas de Música", value: "128", icon: Music, change: "+8" },
  { title: "Notificaciones Enviadas", value: "856", icon: Bell, change: "+23%" },
];

const Admin = () => {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Panel de Administración</h1>
        <p className="text-muted-foreground">Gestiona la plataforma NightWave</p>
      </div>

      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        {stats.map((stat) => (
          <Card key={stat.title}>
            <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
              <CardTitle className="text-sm font-medium">{stat.title}</CardTitle>
              <stat.icon className="h-4 w-4 text-muted-foreground" />
            </CardHeader>
            <CardContent>
              <div className="text-2xl font-bold">{stat.value}</div>
              <p className="text-xs text-primary">{stat.change} desde el mes pasado</p>
            </CardContent>
          </Card>
        ))}
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Acceso Rápido</CardTitle>
          <CardDescription>Enlaces a las funciones principales de administración</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
            <a href="/admin/users" className="block p-4 rounded-lg border border-border hover:bg-secondary transition-colors">
              <Users className="h-6 w-6 mb-2 text-primary" />
              <h3 className="font-semibold">Gestionar Usuarios</h3>
              <p className="text-sm text-muted-foreground">Ver y editar usuarios</p>
            </a>
            <a href="/admin/recompensas" className="block p-4 rounded-lg border border-border hover:bg-secondary transition-colors">
              <Gift className="h-6 w-6 mb-2 text-primary" />
              <h3 className="font-semibold">Recompensas</h3>
              <p className="text-sm text-muted-foreground">Configurar premios</p>
            </a>
            <a href="/admin/musica" className="block p-4 rounded-lg border border-border hover:bg-secondary transition-colors">
              <Music className="h-6 w-6 mb-2 text-primary" />
              <h3 className="font-semibold">Biblioteca Musical</h3>
              <p className="text-sm text-muted-foreground">Gestionar pistas</p>
            </a>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

export default Admin;
