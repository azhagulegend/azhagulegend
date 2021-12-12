

$sourceDir = 'C:\Azhagu\Workspace\ProjectAlpha\src'
$DestinationDir= 'C:\Azhagu\Repo\azhagulegend\src'

$TodayStartTime = get-date -UFormat %d-%m-%Y
$TodayStartTime=[Datetime]::ParseExact($nowtime1, 'MM-dd-yyyy', $null)
Write-Host $TodayStartTime


Get-ChildItem -Recurse $sourceDir | Foreach {
$lastupdatetime=$_.LastWriteTime
if ($TodayStartTime - $lastupdatetime -le 0)
{
Write-Host "File modified within 24 hours "$_.Name
$_.Extension
$_.BaseName
$_.FullName


$destinationpath = $_.FullName.Replace($sourceDir,$DestinationDir)
$destinationpath

$destinationpath = $destinationpath.Replace($_.Name,"")
$destinationpath

If(!(test-path $destinationpath))
{
      New-Item -ItemType Directory -Force -Path $destinationpath
}




Copy-Item -Path $_.FullName -Destination $destinationpath
}
else
{

}
}