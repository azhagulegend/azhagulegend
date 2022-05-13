

$sourceDir = 'C:\Azhagu\Workspace\ProjectAlpha\'
$DestinationDir = 'C:\Azhagu\Repo\azhagulegend\'

#$args[0]
$nowtime1 = get-date -UFormat %d-%m-%Y
Write-Host $TodayStartTime
$TodayStartTime = [Datetime]::ParseExact($nowtime1, 'dd-MM-yyyy', $null)
# Write-Host $TodayStartTime

Get-ChildItem -Recurse $sourceDir | ForEach-Object {
      $lastupdatetime = $_.LastWriteTime
      # Write-Host $lastupdatetime
      Write-Host $_.Name
      Write-Host ($TodayStartTime - $lastupdatetime -le 0)
      Write-Host $TodayStartTime       
      Write-Host $lastupdatetime
      
      if ($TodayStartTime - $lastupdatetime -le 0) {
            Write-Host "File modified within 24 hours "$_.Name
            $_.Extension
            $_.BaseName
            $_.FullName


            $destinationpath = $_.FullName.Replace($sourceDir, $DestinationDir)
            $destinationpath

            $destinationpath = $destinationpath.Replace($_.Name, "")
            $destinationpath

            If (!(test-path $destinationpath)) {
                  New-Item -ItemType Directory -Force -Path $destinationpath
            }
            Copy-Item -Path $_.FullName -Destination $destinationpath
      }
}