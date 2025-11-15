import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Calendar } from "@/components/ui/calendar";
import { useState } from "react";

const activities = [
  { id: 1, title: "Yoga nocturno", time: "20:00", duration: "30 min" },
  { id: 2, title: "Lectura", time: "21:00", duration: "45 min" },
  { id: 3, title: "Ducha relajante", time: "21:45", duration: "15 min" },
];

const Actividades = () => {
  const [date, setDate] = useState<Date | undefined>(new Date());

  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Actividades</h1>
        <p className="text-muted-foreground">Planifica tu rutina nocturna</p>
      </div>

      <div className="grid gap-6 md:grid-cols-2">
        <div className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle>Rutina de Hoy</CardTitle>
              <CardDescription>Actividades programadas para hoy</CardDescription>
            </CardHeader>
            <CardContent className="space-y-3">
              {activities.map((activity) => (
                <div
                  key={activity.id}
                  className="flex items-center justify-between rounded-lg border border-border p-3"
                >
                  <div>
                    <h3 className="font-medium">{activity.title}</h3>
                    <p className="text-sm text-muted-foreground">{activity.duration}</p>
                  </div>
                  <div className="text-right">
                    <div className="text-sm font-medium">{activity.time}</div>
                    <Button size="sm" variant="ghost" className="h-7 text-xs">
                      Completar
                    </Button>
                  </div>
                </div>
              ))}
            </CardContent>
          </Card>

          <Button className="w-full">Agregar Actividad</Button>
        </div>

        <Card>
          <CardHeader>
            <CardTitle>Calendario</CardTitle>
            <CardDescription>Selecciona un día para ver actividades</CardDescription>
          </CardHeader>
          <CardContent className="flex justify-center">
            <Calendar
              mode="single"
              selected={date}
              onSelect={setDate}
              className="rounded-md border"
            />
          </CardContent>
        </Card>
      </div>
    </div>
  );
};

export default Actividades;
