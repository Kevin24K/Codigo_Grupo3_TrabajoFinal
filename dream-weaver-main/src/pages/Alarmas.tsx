import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Switch } from "@/components/ui/switch";
import { AlarmClock, Plus } from "lucide-react";

const alarms = [
  { id: 1, time: "06:30", label: "Despertar temprano", enabled: true, days: ["L", "M", "X", "J", "V"] },
  { id: 2, time: "07:00", label: "Despertar normal", enabled: true, days: ["L", "M", "X", "J", "V"] },
  { id: 3, time: "09:00", label: "Fin de semana", enabled: false, days: ["S", "D"] },
];

const Alarmas = () => {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold tracking-tight">Alarmas</h1>
          <p className="text-muted-foreground">Gestiona tus alarmas de despertar</p>
        </div>
        <Button>
          <Plus className="mr-2 h-4 w-4" />
          Nueva Alarma
        </Button>
      </div>

      <div className="space-y-4">
        {alarms.map((alarm) => (
          <Card key={alarm.id}>
            <CardContent className="flex items-center justify-between p-6">
              <div className="flex items-center gap-4">
                <div className="flex h-12 w-12 items-center justify-center rounded-full bg-primary/10">
                  <AlarmClock className="h-6 w-6 text-primary" />
                </div>
                <div>
                  <div className="text-2xl font-bold">{alarm.time}</div>
                  <div className="text-sm text-muted-foreground">{alarm.label}</div>
                  <div className="flex gap-1 mt-1">
                    {alarm.days.map((day) => (
                      <span
                        key={day}
                        className="flex h-6 w-6 items-center justify-center rounded-full bg-secondary text-xs font-medium"
                      >
                        {day}
                      </span>
                    ))}
                  </div>
                </div>
              </div>
              <Switch defaultChecked={alarm.enabled} />
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
};

export default Alarmas;
